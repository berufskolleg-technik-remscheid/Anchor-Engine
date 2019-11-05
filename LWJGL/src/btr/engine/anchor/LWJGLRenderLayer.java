package btr.engine.anchor;

import btr.engine.anchor.bridge.render.RenderManager;
import btr.engine.anchor.bridge.render.simple.SimpleRenderLayer;
import btr.engine.anchor.bridge.settings.render.RenderSettings;
import btr.engine.anchor.bridge.settings.window.WindowSettings;
import btr.engine.anchor.render.renderer.LWJGLRenderManager;
import btr.engine.anchor.render.setting.LWJGLRenderSettings;
import btr.engine.anchor.render.setting.LWJGLWindowSettings;
import btr.engine.anchor.render.callbacks.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class LWJGLRenderLayer implements SimpleRenderLayer {

    long window;
    LWJGLRenderManager renderManager;
    LWJGLRenderSettings renderSettings;
    LWJGLWindowSettings windowSettings;

    GLFWErrorCallback errorCallback;
    GLFWKeyCallback keyCallback;
    GLFWMouseButtonCallback mouseButtonCallback;
    GLFWScrollCallback scrollCallback;
    GLFWWindowSizeCallback windowSizeCallback;

    GLFWVidMode vidMode;

    @Override
    public void init() {
        setRenderSettings(new LWJGLRenderSettings());
        setWindowSettings(new LWJGLWindowSettings());
        errorCallback = GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) throw new RuntimeException("GLFW cloud not be initialized!");
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, windowSettings.isResizable() ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, windowSettings.isVisible() ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);
        window = GLFW.glfwCreateWindow(windowSettings.getWidth(), windowSettings.getHeight(), windowSettings.getTitle(), windowSettings.isFullscreen() ? GLFW.glfwGetPrimaryMonitor() : MemoryUtil.NULL, MemoryUtil.NULL);
        setRenderManager(new LWJGLRenderManager(this));
        if (window == MemoryUtil.NULL) throw new RuntimeException("Window could not be created");
        vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        if (vidMode == null) throw new RuntimeException("VidMode could not be found!");
        if (!windowSettings.isFullscreen())
            GLFW.glfwSetWindowPos(window, (vidMode.width() - windowSettings.getWidth()) / 2, (vidMode.height() - windowSettings.getHeight()) / 2);
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwSetKeyCallback(window, keyCallback = new KeyCallback());
        GLFW.glfwSetMouseButtonCallback(window, mouseButtonCallback = new MouseButtonCallback());
        GLFW.glfwSetScrollCallback(window, scrollCallback = new ScrollCallback());
        GLFW.glfwSetWindowSizeCallback(window, windowSizeCallback = new WindowSizeCallback());
        GL.createCapabilities();
        if (renderSettings.isVSync())
            GLFW.glfwSwapInterval(1);
        GLFW.glfwShowWindow(window);
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    @Override
    public void end() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        errorCallback.free();
    }

    @Override
    public void setRenderManager(RenderManager renderManager) {
        if (renderManager instanceof LWJGLRenderManager) {
            this.renderManager = (LWJGLRenderManager) renderManager;
        }
    }

    @Override
    public void setRenderSettings(RenderSettings renderSettings) {
        if (renderSettings instanceof LWJGLRenderSettings) {
            this.renderSettings = (LWJGLRenderSettings) renderSettings;
        }
    }

    @Override
    public void setWindowSettings(WindowSettings windowSettings) {
        if (windowSettings instanceof LWJGLWindowSettings) {
            this.windowSettings = (LWJGLWindowSettings) windowSettings;
        }
    }

    public GLFWVidMode getVidMode() {
        return vidMode;
    }

    public long getWindow() {
        return window;
    }

    @Override
    public RenderManager getRenderManager() {
        return renderManager;
    }
}