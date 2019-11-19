package btr.engine.anchor;

import btr.engine.anchor.bridge.audio.simple.SimpleAudioLayer;
import btr.engine.anchor.bridge.render.simple.SimpleRenderLayer;
import btr.engine.anchor.game.loop.GameLoop;

public class AnchorEngine {

    private GameLoop gameLoop;
    private SimpleRenderLayer simpleRenderLayer;
    private SimpleAudioLayer simpleAudioLayer;

    public AnchorEngine(SimpleRenderLayer renderLayer, SimpleAudioLayer audioLayer) {
        simpleRenderLayer = renderLayer;
        simpleAudioLayer = audioLayer;
    }

    public void init() {
        gameLoop = new GameLoop(this);
    }

    public void run() {
        gameLoop.run();
    }

    public SimpleRenderLayer getSimpleRenderLayer() {
        return simpleRenderLayer;
    }

    public SimpleAudioLayer getSimpleAudioLayer() {
        return simpleAudioLayer;
    }
}