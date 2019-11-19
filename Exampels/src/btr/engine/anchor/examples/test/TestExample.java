package btr.engine.anchor.examples.test;

import btr.engine.anchor.AnchorEngine;
import btr.engine.anchor.bridge.layer.audio.AudioLayer;
import btr.engine.anchor.bridge.layer.render.RenderLayer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestExample {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchMethodException, ClassNotFoundException {
        AnchorEngine anchorEngine = new AnchorEngine(RenderLayer.OPENGL, AudioLayer.OPENAL);
        anchorEngine.init();
        anchorEngine.getSimpleRenderLayer().init();
        anchorEngine.run();

    }
}