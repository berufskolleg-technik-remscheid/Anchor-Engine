package btr.anchor.bridge.output;

import btr.anchor.engine.sound.Sound;

public interface IAudioOut extends IOut {

    void play(Sound sound, int streamId);

    void pause(int streamId);

}