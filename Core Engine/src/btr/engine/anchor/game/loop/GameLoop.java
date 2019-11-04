package btr.engine.anchor.game.loop;

import btr.engine.anchor.AnchorEngine;

public class GameLoop {

    AnchorEngine anchorEngine;

    public boolean run = false;

    public GameLoop(AnchorEngine anchorEngine) {
        this.anchorEngine = anchorEngine;
    }

    public void run() {
        run = true;
        while (run) {
            anchorEngine.getSimpleRenderLayer().getRenderManager().render(null);
        }
    }
}