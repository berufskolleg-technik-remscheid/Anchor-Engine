package btr.anchor.editor;

import btr.anchor.engine.AnchorEngine;
import btr.anchor.engine.util.TargetSystem;
import btr.anchor.engine.util.enums.ReleaseState;

public class Main {

    AnchorEngine engine;

    public Main() {
        engine = new AnchorEngine(TargetSystem.ANDROID, "BTR App", 0.01, ReleaseState.ALPHA);
    }
}