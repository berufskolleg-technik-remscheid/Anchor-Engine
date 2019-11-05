package btr.engine.anchor.lwjgl.render.callbacks;

import btr.engine.anchor.lwjgl.LWJGLRenderLayer;
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
