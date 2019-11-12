package btr.engine.anchor.examples.test;

import btr.engine.anchor.AnchorEngine;
import btr.engine.anchor.bridge.audio.simple.SimpleAudioLayer;
import btr.engine.anchor.bridge.render.simple.SimpleRenderLayer;
import btr.engine.anchor.lwjgl.openal.OpenALAudioLayer;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;

public class TestExample {

    public static void main(String[] args) {
        SimpleRenderLayer simpleRenderLayer = new OpenGLRenderLayer();
        SimpleAudioLayer simpleAudioLayer = new OpenALAudioLayer();
        AnchorEngine anchorEngine = new AnchorEngine(simpleRenderLayer, simpleAudioLayer);
        anchorEngine.init();
        anchorEngine.getSimpleRenderLayer().init();
        anchorEngine.run();

    }
}