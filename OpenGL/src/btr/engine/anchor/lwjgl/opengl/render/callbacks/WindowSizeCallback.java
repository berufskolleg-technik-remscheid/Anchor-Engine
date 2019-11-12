package btr.engine.anchor.lwjgl.opengl.render.callbacks;

import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

public class WindowSizeCallback extends GLFWWindowSizeCallback {

    OpenGLRenderLayer renderLayer;

    public WindowSizeCallback(OpenGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public void invoke(long window, int x, int y) {
        this.renderLayer.getWindowSettings().setWidth(x);
        this.renderLayer.getWindowSettings().setHeight(y);
    }
}
