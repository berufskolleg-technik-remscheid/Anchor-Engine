package btr.engine.anchor.lwjgl.opengl;

import btr.engine.anchor.bridge.render.RenderManager;
import btr.engine.anchor.bridge.render.simple.SimpleRenderLayer;
import btr.engine.anchor.bridge.settings.render.RenderSettings;
import btr.engine.anchor.bridge.settings.window.WindowSettings;
import btr.engine.anchor.lwjgl.opengl.render.callbacks.*;
import btr.engine.anchor.lwjgl.opengl.render.renderer.OpenGLRenderManager;
import btr.engine.anchor.lwjgl.opengl.render.setting.OpenGLRenderSettings;
import btr.engine.anchor.lwjgl.opengl.render.setting.OpenGLWindowSettings;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class OpenGLRenderLayer extends SimpleRenderLayer {

    long window;
    OpenGLRenderManager renderManager;
    OpenGLRenderSettings renderSettings;
    OpenGLWindowSettings windowSettings;

    GLFWErrorCallback errorCallback;
    GLFWKeyCallback keyCallback;
    GLFWMouseButtonCallback mouseButtonCallback;
    GLFWScrollCallback scrollCallback;
    GLFWWindowSizeCallback windowSizeCallback;
    GLFWCursorPosCallback cursorPosCallback;
    GLFWDropCallback dropCallback;
    GLFWWindowCloseCallback windowCloseCallback;
    GLFWWindowRefreshCallback windowRefreshCallback;

    GLFWVidMode vidMode;

    @Override
    public void init() {
        setRenderSettings(new OpenGLRenderSettings(this));
        setWindowSettings(new OpenGLWindowSettings(this));
        errorCallback = GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) throw new RuntimeException("GLFW cloud not be initialized!");
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, windowSettings.isResizable() ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, windowSettings.isVisible() ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_MAXIMIZED, GLFW.GLFW_TRUE);
        window = GLFW.glfwCreateWindow(windowSettings.getWidth(), windowSettings.getHeight(), windowSettings.getTitle(), windowSettings.isFullscreen() ? GLFW.glfwGetPrimaryMonitor() : MemoryUtil.NULL, MemoryUtil.NULL);
        setRenderManager(new OpenGLRenderManager(this));
        if (window == MemoryUtil.NULL) throw new RuntimeException("Window could not be created");
        vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        if (vidMode == null) throw new RuntimeException("VidMode could not be found!");
        if (!windowSettings.isFullscreen())
            GLFW.glfwSetWindowPos(window, (vidMode.width() - windowSettings.getWidth()) / 2, (vidMode.height() - windowSettings.getHeight()) / 2);
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwSetKeyCallback(window, keyCallback = new KeyCallback(this));
        GLFW.glfwSetCursorPosCallback(window, cursorPosCallback = new CursorPositionCallback(this));
        GLFW.glfwSetMouseButtonCallback(window, mouseButtonCallback = new MouseButtonCallback(this));
        GLFW.glfwSetScrollCallback(window, scrollCallback = new ScrollCallback(this));
        GLFW.glfwSetWindowSizeCallback(window, windowSizeCallback = new WindowSizeCallback(this));
        GLFW.glfwSetWindowCloseCallback(window, windowCloseCallback = new WindowCloseCallback(this));
        GLFW.glfwSetDropCallback(window, dropCallback = new DropCallback(this));
        GLFW.glfwSetWindowRefreshCallback(window, windowRefreshCallback = new WindowRefreshCallback(this));
        GL.createCapabilities();
        if (renderSettings.isVSync())
            GLFW.glfwSwapInterval(1);
        GLFW.glfwShowWindow(window);
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_DEPTH_TEST | GL11.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void end() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        errorCallback.free();
    }

    @Override
    public void setRenderManager(RenderManager renderManager) {
        if (renderManager instanceof OpenGLRenderManager) {
            this.renderManager = (OpenGLRenderManager) renderManager;
        }
    }

    @Override
    public void setRenderSettings(RenderSettings renderSettings) {
        if (renderSettings instanceof OpenGLRenderSettings) {
            this.renderSettings = (OpenGLRenderSettings) renderSettings;
        }
    }

    @Override
    public void setWindowSettings(WindowSettings windowSettings) {
        if (windowSettings instanceof OpenGLWindowSettings) {
            this.windowSettings = (OpenGLWindowSettings) windowSettings;
        }
    }

    public GLFWVidMode getVidMode() {
        return vidMode;
    }

    public long getWindow() {
        return window;
    }

    public OpenGLWindowSettings getWindowSettings() {
        return windowSettings;
    }

    @Override
    public RenderManager getRenderManager() {
        return renderManager;
    }

}