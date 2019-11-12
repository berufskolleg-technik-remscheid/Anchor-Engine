package btr.engine.anchor.lwjgl.opengl.render.setting;

import btr.engine.anchor.bridge.settings.render.RenderSettings;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import org.lwjgl.glfw.GLFW;

public class LWJGLRenderSettings implements RenderSettings {

    private boolean vsync;
    private int msaa; // Multisample antialising

    private OpenGLRenderLayer renderLayer;

    public LWJGLRenderSettings(OpenGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
        this.vsync = true;
    }

    @Override
    public void update() {
        GLFW.glfwSwapInterval(vsync ? 1 : 0);
        GLFW.glfwSetWindowOpacity(renderLayer.getWindow(), 0.1f);
    }

    @Override
    public boolean isVSync() {
        return vsync;
    }

    @Override
    public int getMSAA() {
        return msaa;
    }

    @Override
    public void setVSync(boolean enable) {
        this.vsync = enable;
    }

    @Override
    public void setMSAA(int msaa) {
        this.msaa = msaa;
    }
}