package btr.engine.anchor.lwjgl.render.callbacks;

import btr.engine.anchor.lwjgl.LWJGLRenderLayer;
import org.lwjgl.glfw.GLFWWindowCloseCallback;

public class WindowCloseCallback extends GLFWWindowCloseCallback {

    LWJGLRenderLayer renderLayer;

    public WindowCloseCallback(LWJGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }


    @Override
    public void invoke(long window) {
        
    }
}
