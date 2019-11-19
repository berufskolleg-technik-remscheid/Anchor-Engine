package btr.engine.anchor.editor;

import btr.engine.anchor.AnchorEngine;
import btr.engine.anchor.layer.audio.AudioLayer;
import btr.engine.anchor.layer.render.RenderLayer;

public class Editor extends AnchorEngine {

    public Editor() {
        super(RenderLayer.OPENGL, AudioLayer.OPENAL);
    }
}