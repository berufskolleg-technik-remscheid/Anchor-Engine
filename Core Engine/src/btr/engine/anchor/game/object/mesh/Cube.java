package btr.engine.anchor.game.object.mesh;

import btr.engine.anchor.bridge.object.AnchorObject;
import btr.engine.anchor.bridge.object.mesh.Mesh;

public class Cube extends AnchorObject {

    public Cube(String name) {
        super(name);
        setMesh(new Mesh(new float[] {
                -1.0f, -1.0f, 0.0f,
                 0.0f, 1.0f, 0.0f,
                 1.0f, -1.0f, 0.0f,
        }));
    }
}