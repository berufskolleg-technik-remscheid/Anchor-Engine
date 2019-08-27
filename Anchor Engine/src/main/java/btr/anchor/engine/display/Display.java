package btr.anchor.engine.display;

import btr.anchor.bridge.output.IDisplayOut;
import btr.anchor.engine.AnchorEngine;
import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.util.objects.GameObject;
import btr.anchor.engine.util.settings.DisplaySettings;

public class Display {

    IDisplayOut displayOut;

    DisplayImage renderImage;

    public Display(IDisplayOut display) {
    }

    public void renderImage() {
        renderImage = new DisplayImage(DisplaySettings.width, DisplaySettings.height);
        for (GameObject obj : AnchorEngine.instance.game.getGameObjects()) {
            // calculate object shader
            // add GameObjects to renderImage
        }
        // calculate game shaders
    }

}