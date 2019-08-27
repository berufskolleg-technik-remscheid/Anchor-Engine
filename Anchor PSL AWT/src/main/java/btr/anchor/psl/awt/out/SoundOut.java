package btr.anchor.psl.awt.out;

import btr.anchor.bridge.output.ISoundOut;
import btr.anchor.engine.sound.Sound;

public class SoundOut implements ISoundOut {

    public SoundOut() {
    }

    @Override
    public int playSound(Sound sound) {
        return 0;
    }

    @Override
    public void stopSound(int id) {

    }
}
