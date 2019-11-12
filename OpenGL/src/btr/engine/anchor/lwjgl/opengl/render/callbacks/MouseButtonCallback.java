package btr.engine.anchor.lwjgl.opengl.render.callbacks;

import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class MouseButtonCallback extends GLFWMouseButtonCallback {

    OpenGLRenderLayer renderLayer;

    public MouseButtonCallback(OpenGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public void invoke(long window, int i, int i1, int i2) {

    }
}
