package btr.anchor.bridge.output;

import btr.anchor.engine.sound.Sound;

public interface ISoundOut extends IOut {

    int playSound(Sound sound);

    void stopSound(int id);


}