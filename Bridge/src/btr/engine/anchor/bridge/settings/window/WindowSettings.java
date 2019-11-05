package btr.engine.anchor.bridge.settings.window;

import java.awt.image.BufferedImage;

public interface WindowSettings {

    /* window actions */

    public void close();

    public void hide();

    public void show();

    public void update();

    public void focus();

    /* window variables */

    public boolean isResizable();

    public int getWidth();

    public int getHeight();

    public boolean isFullscreen();

    public String getTitle();

    public boolean isVisible();

    public void setFullscreen(boolean fullscreen);

    public void setTitle(String title);

    public void setWidth(int width);

    public void setHeight(int height);

    public void setCursor(BufferedImage image);

    public void setResizable(boolean resizable);

    public void setVisible(boolean visible);

}