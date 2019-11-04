package btr.engine.anchor.render.setting;

import btr.engine.anchor.bridge.settings.window.WindowSettings;
import btr.engine.anchor.exceptions.NotSupportedException;

import java.awt.image.BufferedImage;

public class LWJGLWindowSettings implements WindowSettings {

    int width;
    int height;
    boolean fullscreen;
    boolean resizable;
    boolean visible;
    String title;

    public LWJGLWindowSettings() {
        this.width = 800;
        this.height = 600;
        this.fullscreen = false;
        this.resizable = false;
        this.visible = true;
        this.title = "AnchorEngineTest";
    }

    public LWJGLWindowSettings(int width, int height, int x, int y, boolean fullscreen, boolean resizable, boolean visible, String title) {
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
        this.resizable = resizable;
        this.visible = visible;
        this.title = title;
    }

    @Override
    public void close() {
        throw new NotSupportedException();
    }

    @Override
    public void hide() {
        throw new NotSupportedException();
    }

    @Override
    public void show() {
        throw new NotSupportedException();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean isResizable() {
        return false;
    }

    @Override
    public boolean isFullscreen() {
        return fullscreen;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    @Override
    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public void setCursor(BufferedImage image) {

    }
}
