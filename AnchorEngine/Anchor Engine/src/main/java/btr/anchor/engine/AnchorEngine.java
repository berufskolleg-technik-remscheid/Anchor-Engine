package btr.anchor.engine;

import btr.anchor.engine.util.TargetSystem;
import btr.anchor.engine.util.enums.ReleaseState;
import btr.anchor.engine.util.loop.GameLoop;

public class AnchorEngine {

    public final TargetSystem TARGETSYSTEM;
    public final String APPNAME;
    public final double VERSION;
    public final ReleaseState RELEASESTATE;

    private GameLoop gameLoop;

    private boolean run;


    public AnchorEngine(TargetSystem targetSystem, String appName, double version, ReleaseState releaseState) {
        this.TARGETSYSTEM = targetSystem;
        this.APPNAME = appName;
        this.VERSION = version;
        this.RELEASESTATE = releaseState;
        run = true;
    }

    public void init() {

    }

    public void loop() {
        gameLoop = new GameLoop();
        gameLoop.start();
    }

    public void stop() {

    }

}