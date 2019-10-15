package btr.anchor.engine.pidl;

import btr.anchor.bridge.output.*;
import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.shader.filter.FilterHandler;

public abstract class PlatformIndependenceLayer {

    protected IDisplayOut displayOut;
    protected IAudioOut audioOut;
    protected IFileOut fileOut;
    protected IDisplaySettingsOut displaySettingsOut;
    protected ISoundOut soundOut;

    protected FilterHandler filterHandler;

    protected DisplayImage currentImage;

    public abstract void repaint();

    public abstract void init();

    public void setCurrentImage(DisplayImage image) {
        this.currentImage = image;
    }

    public IDisplayOut getDisplayOut() {
        return displayOut;
    }

    public DisplayImage getCurrentImage() {
        return currentImage;
    }

    public IAudioOut getAudioOut() {
        return audioOut;
    }

    public IDisplaySettingsOut getDisplaySettingsOut() {
        return displaySettingsOut;
    }

    public IFileOut getFileOut() {
        return fileOut;
    }

    public ISoundOut getSoundOut() {
        return soundOut;
    }

    public FilterHandler getFilterHandler() {
        return filterHandler;
    }
}