package btr.anchor.games.sandbox;

import btr.anchor.engine.AnchorEngine;
import btr.anchor.engine.shader.filter.defaultfilter.DefaultBlackWhiteFilter;
import btr.anchor.engine.util.enums.ReleaseState;
import btr.anchor.engine.util.enums.TargetSystem;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AnchorEngine engine = new AnchorEngine(TargetSystem.PC, "Sandbox", 0.1, ReleaseState.ALPHA, false);
        engine.pidl.getFilterHandler().registerFilter(new DefaultBlackWhiteFilter());
    }

}