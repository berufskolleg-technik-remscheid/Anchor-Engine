package btr.engine.anchor.bridge.settings.render;

public interface RenderSettings {

    public void update();

    public boolean isVSync();

    public int getMSAA();

    public void setVSync(boolean enable);

    public void setMSAA(int msaa);
}