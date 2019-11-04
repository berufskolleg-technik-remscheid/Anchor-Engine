package btr.engine.anchor.render.setting;

import btr.engine.anchor.bridge.settings.render.RenderSettings;
import org.lwjgl.glfw.GLFW;

public class LWJGLRenderSettings implements RenderSettings {

    private boolean vsync;
    private int msaa; // Multisample antialising


    public LWJGLRenderSettings() {
        this.vsync = true;
    }

    @Override
    public void update() {
        GLFW.glfwSwapInterval(vsync ? 1 : 0);
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