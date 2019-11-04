package btr.engine.anchor.bridge.render;

import btr.engine.anchor.bridge.settings.render.RenderSettings;
import btr.engine.anchor.bridge.settings.window.WindowSettings;

public interface RenderLayer {

    public void init();

    public void end();

    public void setRenderManager(RenderManager renderManager);

    public void setRenderSettings(RenderSettings renderSetting);

    public void setWindowSettings(WindowSettings windowSettings);

}