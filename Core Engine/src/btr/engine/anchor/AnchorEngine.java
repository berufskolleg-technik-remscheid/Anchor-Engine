package btr.engine.anchor;

import btr.engine.anchor.bridge.audio.simple.SimpleAudioLayer;
import btr.engine.anchor.bridge.layer.LayerType;
import btr.engine.anchor.bridge.render.simple.SimpleRenderLayer;
import btr.engine.anchor.classloader.layer.LayerLoader;
import btr.engine.anchor.game.loop.GameLoop;
import btr.engine.anchor.bridge.layer.audio.AudioLayer;
import btr.engine.anchor.bridge.layer.render.RenderLayer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AnchorEngine {

    private GameLoop gameLoop;
    private SimpleRenderLayer simpleRenderLayer;
    private SimpleAudioLayer simpleAudioLayer;

    public AnchorEngine(RenderLayer renderLayer, AudioLayer audioLayer) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        LayerLoader loader = new LayerLoader(LayerType.RENDER, renderLayer);
        this.simpleRenderLayer = (SimpleRenderLayer) loader.load().getConstructor(new Class<?>[]{}).newInstance();
        loader = new LayerLoader(LayerType.AUDIO, audioLayer);
        this.simpleAudioLayer = (SimpleAudioLayer) loader.load().getConstructor(new Class[]{}).newInstance();
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