package btr.anchor.engine.bridge.output;

import java.awt.image.BufferedImage;

public interface IDisplayOutput extends IOutput {

    void show(BufferedImage image);

}