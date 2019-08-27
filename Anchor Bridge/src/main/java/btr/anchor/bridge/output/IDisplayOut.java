package btr.anchor.bridge.output;

import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.util.color.Color;

public interface IDisplayOut extends IOut {

    void display(DisplayImage image);

    void display(String message, int x, int y, Color color);
}