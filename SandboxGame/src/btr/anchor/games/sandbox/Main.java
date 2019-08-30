package btr.anchor.games.sandbox;

import btr.anchor.engine.AnchorEngine;
import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.util.enums.ReleaseState;
import btr.anchor.engine.util.enums.TargetSystem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AnchorEngine engine = new AnchorEngine(TargetSystem.PC, "Sandbox", 0.1, ReleaseState.ALPHA);
        BufferedImage image = ImageIO.read(new File("./res/anchor_960_1280.jpg"));

        DisplayImage dp = new DisplayImage(image.getWidth(), image.getHeight());
        dp.scale(600, 400);

        dp.setPixels(image.getRGB(0, 0, dp.width, dp.height, null, 0, dp.width));
        engine.pidl.setCurrentImage(dp);
    }

}