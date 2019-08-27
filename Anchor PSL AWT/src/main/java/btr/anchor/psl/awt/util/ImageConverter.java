package btr.anchor.psl.awt.util;

import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.util.exception.AnchorEngineException;

import java.awt.image.BufferedImage;

public class ImageConverter {

    public static BufferedImage displayImageToBufferedImage(DisplayImage image) {
        if (image == null) {
            throw new AnchorEngineException();
        }
        if (image.width <= 0 || image.height <= 0) {
            throw new AnchorEngineException();
        }
        BufferedImage buff = new BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_RGB);
        buff.setRGB(0, 0, image.width, image.height, image.getColorArray(), 0, image.width);
        return buff;
    }
}