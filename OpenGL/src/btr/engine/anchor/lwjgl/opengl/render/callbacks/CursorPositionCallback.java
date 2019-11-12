package btr.engine.anchor.lwjgl.opengl.render.callbacks;

import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import org.lwjgl.glfw.GLFWCursorPosCallback;

public class CursorPositionCallback extends GLFWCursorPosCallback {

    OpenGLRenderLayer renderLayer;

    public CursorPositionCallback(OpenGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public void invoke(long window, double xpos, double ypos) {

    }
}
