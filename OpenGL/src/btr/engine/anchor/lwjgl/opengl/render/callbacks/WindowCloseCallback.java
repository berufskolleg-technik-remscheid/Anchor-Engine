package btr.engine.anchor.lwjgl.opengl.render.callbacks;

import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import org.lwjgl.glfw.GLFWWindowCloseCallback;

public class WindowCloseCallback extends GLFWWindowCloseCallback {

    OpenGLRenderLayer renderLayer;

    public WindowCloseCallback(OpenGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }


    @Override
    public void invoke(long window) {
        
    }
}
