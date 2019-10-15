package btr.anchor.engine.util.loop;

import btr.anchor.engine.AnchorEngine;
import btr.anchor.engine.util.color.Color;
import btr.anchor.engine.util.exception.AnchorEngineException;
import btr.anchor.engine.util.fps.FPS;

public class GameLoop {

    int maxFramerate; // 0 is unlimited

    boolean run;

    public GameLoop() {
        this.maxFramerate = 0;
        this.run = true;
    }

    public GameLoop(int maxFramerate) {
        this.maxFramerate = maxFramerate;
        this.run = true;
    }

    public void start() {
        while (run) {
            try {
                // loop start
                if (FPS.maxFPS > 0) {
                    long deltaTime = System.currentTimeMillis() - FPS.lastStamp;
                    if (FPS.maxFPS < 1000f / deltaTime) continue;
                }
                // calculate
                AnchorEngine.instance.pidl.repaint();
                // loop end
                // update fps
                FPS.update();
                AnchorEngine.instance.pidl.getDisplayOut().display("FPS: " + FPS.fps, 100, 100, Color.Colors.RED.color);
            } catch (AnchorEngineException e) {
                if (e.isCritical()) {
                    e.printStackTrace(); // TODO: handle critical error
                } else {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        run = false;
    }
}