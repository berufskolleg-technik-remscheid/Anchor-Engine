package btr.engine.anchor.render.callbacks;

import btr.engine.anchor.LWJGLRenderLayer;
import org.lwjgl.glfw.GLFWCursorPosCallback;

public class CursorPositionCallback extends GLFWCursorPosCallback {

    LWJGLRenderLayer renderLayer;

    public CursorPositionCallback(LWJGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public void invoke(long window, double xpos, double ypos) {

    }
}
