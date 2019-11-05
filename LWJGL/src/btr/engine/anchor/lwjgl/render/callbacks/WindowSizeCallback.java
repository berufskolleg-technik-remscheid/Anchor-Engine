package btr.engine.anchor.lwjgl.render.callbacks;

import btr.engine.anchor.lwjgl.LWJGLRenderLayer;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

public class WindowSizeCallback extends GLFWWindowSizeCallback {

    LWJGLRenderLayer renderLayer;

    public WindowSizeCallback(LWJGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public void invoke(long window, int x, int y) {
        this.renderLayer.getWindowSettings().setWidth(x);
        this.renderLayer.getWindowSettings().setHeight(y);
    }
}
