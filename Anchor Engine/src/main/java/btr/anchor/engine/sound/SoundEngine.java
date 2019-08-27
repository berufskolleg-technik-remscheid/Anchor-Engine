package btr.anchor.engine.sound;

import btr.anchor.engine.AnchorEngine;

public class SoundEngine {

    public static void playSound(Sound sound) {
        AnchorEngine.instance.pidl.getSoundOut().playSound(sound);
    }

}