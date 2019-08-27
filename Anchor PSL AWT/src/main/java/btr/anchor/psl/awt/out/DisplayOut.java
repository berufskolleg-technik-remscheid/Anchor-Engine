package btr.anchor.psl.awt.out;

import btr.anchor.bridge.output.IDisplayOut;
import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.util.color.Color;
import btr.anchor.psl.awt.PSLAwt;
import btr.anchor.psl.awt.util.DisplayString;

import java.awt.image.BufferedImage;

public class DisplayOut implements IDisplayOut {

    @Override
    public void display(DisplayImage image) {
        BufferedImage bi = new BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_RGB);
        bi.setRGB(0, 0, image.width, image.height, image.getColorArray(), 0, 1);
    }

    @Override
    public void display(String message, int x, int y, Color color) {
        PSLAwt.instance.displayStrings.add(new DisplayString(message, x, y, color));
    }
}
