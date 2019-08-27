package btr.anchor.editor.display;

import btr.anchor.engine.AnchorEngine;
import btr.anchor.engine.util.enums.ReleaseState;
import btr.anchor.engine.util.enums.TargetSystem;
import btr.anchor.engine.util.log.Logger;
import btr.anchor.psl.awt.PSLAwt;

import javax.swing.*;

public class Editor {

    public AnchorEngine engine;

    PSLAwt layer;

    JFrame frame;
    JPanel panel;

    public void init() {
        engine = new AnchorEngine(TargetSystem.PC, "BTR App", 0.01, ReleaseState.ALPHA);
        if (engine.pidl instanceof PSLAwt) {
            layer = (PSLAwt) engine.pidl;
        } else {
            Logger.error.send("The Editor cannot start on this Platform(" + engine.TARGETSYSTEM.independenceLayerType.name() + ")");
            return;
        }
    }
}