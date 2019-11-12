package btr.engine.anchor.vulkan;

import btr.engine.anchor.bridge.render.simple.SimpleRenderLayer;
import btr.engine.anchor.vulkan.callback.RefreshCallback;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVulkan;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.*;

import java.nio.IntBuffer;

public class VulkanRenderLayer extends SimpleRenderLayer {

    VkInstance instance;
    VkPhysicalDevice[] physicalDevices;
    long window;

    @Override
    public void init() {
        GLFWErrorCallback.createPrint().set();
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        if (!GLFWVulkan.glfwVulkanSupported()) {
            throw new IllegalStateException("Cannot find a compatible Vulkan installable client driver (ICD)");
        }

        window = GLFW.glfwCreateWindow(windowSettings.getWidth(), windowSettings.getHeight(), windowSettings.getTitle(), windowSettings.isFullscreen() ? GLFW.glfwGetPrimaryMonitor() : MemoryUtil.NULL, MemoryUtil.NULL);
        if (window == MemoryUtil.NULL) {
            throw new IllegalStateException("Cannot create a window in which to draw!");
        }
        GLFW.glfwSetWindowRefreshCallback(window, new RefreshCallback());

        IntBuffer gpuCount = MemoryUtil.memAllocInt(1);
        VK11.vkEnumeratePhysicalDevices(instance, gpuCount, null);
        PointerBuffer devices = MemoryUtil.memAllocPointer(gpuCount.get(0));
        VK11.vkEnumeratePhysicalDevices(instance, gpuCount, devices);

        VkPhysicalDevice device = new VkPhysicalDevice(devices.get(0), instance);
        MemoryUtil.memFree(gpuCount);
        MemoryUtil.memFree(devices);
    }

    @Override
    public void end() {

    }
}