package btr.engine.anchor.lwjgl.render.callbacks;

import btr.engine.anchor.lwjgl.LWJGLRenderLayer;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class MouseButtonCallback extends GLFWMouseButtonCallback {

    LWJGLRenderLayer renderLayer;

    public MouseButtonCallback(LWJGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public void invoke(long window, int i, int i1, int i2) {

    }
}
