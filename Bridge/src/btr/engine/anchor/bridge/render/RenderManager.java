package btr.engine.anchor.bridge.render;

import btr.engine.anchor.bridge.object.AnchorObject;

public interface RenderManager {

    public void init();

    public int[] render(AnchorObject[] anchorObjects);
}