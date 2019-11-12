package btr.engine.anchor.lwjgl.opengl.render.setting;

import btr.engine.anchor.bridge.settings.window.WindowSettings;
import btr.engine.anchor.exceptions.NotSupportedException;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;

import java.awt.image.BufferedImage;

public class LWJGLWindowSettings implements WindowSettings {

    int width;
    int height;
    boolean fullscreen;
    boolean resizable;
    boolean visible;
    String title;
    GLFWImage.Buffer icon;
    OpenGLRenderLayer renderLayer;

    public LWJGLWindowSettings(OpenGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
        this.width = 800;
        this.height = 600;
        this.fullscreen = false;
        this.resizable = false;
        this.visible = true;
        this.title = "AnchorEngine";
    }

    public LWJGLWindowSettings(OpenGLRenderLayer renderLayer, int width, int height, boolean fullscreen, boolean resizable, boolean visible, String title) {
        this.renderLayer = renderLayer;
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
        this.resizable = resizable;
        this.visible = visible;
        this.title = title;
    }

    @Override
    public void update() {
        this.width = fullscreen ? renderLayer.getVidMode().width() : width;
        this.height = fullscreen ? renderLayer.getVidMode().height() : height;
        GLFW.glfwSetWindowSize(renderLayer.getWindow(), getWidth(), getHeight());
        GLFW.glfwSetWindowIcon(renderLayer.getWindow(), icon);
        GLFW.glfwSetWindowTitle(renderLayer.getWindow(), title);
    }

    @Override
    public void focus() {
        GLFW.glfwFocusWindow(renderLayer.getWindow());
    }

    @Override
    public void close() {
        GLFW.glfwSetWindowShouldClose(renderLayer.getWindow(), true);
    }

    @Override
    public void hide() {
        GLFW.glfwHideWindow(renderLayer.getWindow());
    }

    @Override
    public void show() {
        GLFW.glfwShowWindow(renderLayer.getWindow());
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean isResizable() {
        return resizable;
    }

    @Override
    public boolean isFullscreen() {
        return fullscreen;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    @Override
    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public void setCursor(BufferedImage image) {
        throw new NotSupportedException();
    }
}
