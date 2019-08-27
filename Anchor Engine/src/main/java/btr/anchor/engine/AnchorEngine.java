package btr.anchor.engine;

import btr.anchor.engine.game.Game;
import btr.anchor.engine.pidl.IndependenceLayerType;
import btr.anchor.engine.pidl.PlatformIndependenceLayer;
import btr.anchor.engine.util.enums.ReleaseState;
import btr.anchor.engine.util.enums.TargetSystem;
import btr.anchor.engine.util.exception.AnchorEngineException;
import btr.anchor.engine.util.exception.NoPIDLFoundException;
import btr.anchor.engine.util.exception.UnsupportedException;
import btr.anchor.engine.util.fps.FPS;
import btr.anchor.engine.util.loop.GameLoop;
import btr.anchor.engine.util.settings.StartupSetting;
import btr.anchor.psl.awt.PSLAwt;

public class AnchorEngine {

    public final TargetSystem TARGETSYSTEM;
    public final String APPNAME;
    public final double VERSION;
    public final ReleaseState RELEASESTATE;

    public StartupSetting startupSetting;

    public PlatformIndependenceLayer pidl;

    private GameLoop gameLoop;
    public Game game;

    public static AnchorEngine instance;

    public AnchorEngine(TargetSystem targetSystem, String appName, double version, ReleaseState releaseState) throws AnchorEngineException {
        this.TARGETSYSTEM = targetSystem;
        this.APPNAME = appName;
        this.VERSION = version;
        this.RELEASESTATE = releaseState;
        instance = this;
        pidl = createSystemLayer(); // open platform independence layer
        pidl.init();
        FPS.maxFPS = 50;
        init();
        startupSetting = new StartupSetting();
        loop();
    }

    public void init() {
        gameLoop = new GameLoop();
        game = new Game();
        // init keyhandler
        // init mousehandler
        // init shaderhandler
    }

    public void loop() {
        Thread gameLoopThread = new Thread(() -> {
            gameLoop.start();
            Thread.currentThread().interrupt();
        });
        gameLoopThread.setName("GameLoop");
        gameLoopThread.start();
    }

    public void stop() {
        gameLoop.stop();
    }

    public static AnchorEngine getInstance() {
        return instance;
    }

    private PlatformIndependenceLayer createSystemLayer() {
        if (TARGETSYSTEM == TargetSystem.ANDROID) {
            throw new UnsupportedException();
        } else if (TARGETSYSTEM == TargetSystem.PC) {
            if (TARGETSYSTEM.independenceLayerType == IndependenceLayerType.AWT) {
                return new PSLAwt();
            } else if (TARGETSYSTEM.independenceLayerType == IndependenceLayerType.FX) {
                throw new UnsupportedException();
            }
        }
        throw new NoPIDLFoundException();
    }

}