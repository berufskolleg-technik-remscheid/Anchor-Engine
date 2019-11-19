package btr.engine.anchor.examples.test;

import btr.engine.anchor.AnchorEngine;
import btr.engine.anchor.lwjgl.openal.OpenALAudioLayer;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;

public class TestExample {

    public static void main(String[] args) {
        AnchorEngine anchorEngine = new AnchorEngine(new OpenGLRenderLayer(), new OpenALAudioLayer());
        anchorEngine.init();
        anchorEngine.getSimpleRenderLayer().init();
        anchorEngine.run();

    }
}