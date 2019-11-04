package btr.engine.anchor.examples.test;

import btr.engine.anchor.AnchorEngine;
import btr.engine.anchor.LWJGLAudioLayer;
import btr.engine.anchor.LWJGLRenderLayer;
import btr.engine.anchor.bridge.audio.simple.SimpleAudioLayer;
import btr.engine.anchor.bridge.render.simple.SimpleRenderLayer;

public class TestExample {

    public static void main(String[] args) {
        SimpleRenderLayer simpleRenderLayer = new LWJGLRenderLayer();
        SimpleAudioLayer simpleAudioLayer = new LWJGLAudioLayer();
        AnchorEngine anchorEngine = new AnchorEngine(simpleRenderLayer, simpleAudioLayer);
        anchorEngine.init();
        anchorEngine.getSimpleRenderLayer().init();
        anchorEngine.run();

    }
}