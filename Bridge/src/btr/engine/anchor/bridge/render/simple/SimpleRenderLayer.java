package btr.engine.anchor.bridge.render.simple;

import btr.engine.anchor.bridge.render.RenderLayer;
import btr.engine.anchor.bridge.render.RenderManager;
import btr.engine.anchor.bridge.settings.render.RenderSettings;
import btr.engine.anchor.bridge.settings.window.WindowSettings;

public abstract class SimpleRenderLayer implements RenderLayer {

    protected RenderManager renderManager;
    protected RenderSettings renderSettings;
    protected WindowSettings windowSettings;

    public RenderManager getRenderManager() {
        return renderManager;
    }

    public RenderSettings getRenderSettings() {
        return renderSettings;
    }

    public WindowSettings getWindowSettings() {
        return windowSettings;
    }

    @Override
    public void setWindowSettings(WindowSettings windowSettings) {
        this.windowSettings = windowSettings;
    }

    @Override
    public void setRenderManager(RenderManager renderManager) {
        this.renderManager = renderManager;
    }

    @Override
    public void setRenderSettings(RenderSettings renderSettings) {
        this.renderSettings = renderSettings;
    }
}