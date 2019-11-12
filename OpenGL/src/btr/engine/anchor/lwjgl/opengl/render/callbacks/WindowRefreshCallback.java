package btr.engine.anchor.lwjgl.opengl.render.callbacks;

import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;

public class WindowRefreshCallback extends GLFWWindowRefreshCallback {

    OpenGLRenderLayer renderLayer;

    public WindowRefreshCallback(OpenGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public void invoke(long window) {

    }
}
