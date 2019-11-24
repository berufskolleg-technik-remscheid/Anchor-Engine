package btr.engine.anchor.game.loop;

import btr.engine.anchor.AnchorEngine;
import btr.engine.anchor.bridge.object.AnchorObject;
import btr.engine.anchor.game.object.mesh.Rectangle;

public class GameLoop {

    AnchorEngine anchorEngine;

    public boolean run = false;

    public GameLoop(AnchorEngine anchorEngine) {
        this.anchorEngine = anchorEngine;
    }

    public void run() {
        run = true;
        while (run) {
            anchorEngine.getSimpleRenderLayer().getRenderManager().render(new AnchorObject[]{new Rectangle()});
        }
    }
}