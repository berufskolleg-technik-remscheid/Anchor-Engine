package btr.anchor.engine.android.input;

import btr.anchor.engine.android.IAndroidInput;

public interface IAndroidButtonInput extends IAndroidInput {

    boolean isPressed();

    boolean isReleased();

    float lastTimePressed();
}