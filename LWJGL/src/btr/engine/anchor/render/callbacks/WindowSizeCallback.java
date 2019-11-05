package btr.engine.anchor.render.callbacks;

import btr.engine.anchor.LWJGLRenderLayer;
import btr.engine.anchor.render.renderer.LWJGLRenderManager;
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
