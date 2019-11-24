package btr.engine.anchor.game.object.mesh;

import btr.engine.anchor.bridge.object.AnchorObject;
import btr.engine.anchor.bridge.object.mesh.Mesh;

public class Rectangle extends AnchorObject {

    public Rectangle() {
        super("Rectangle", new Mesh(new float[]{
                -0.5f, 0.5f, 0.0f,
                0.5f, 0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
        }, new int[]{
                0, 1, 2,
                0, 3, 2}));
    }

    @Override
    public Mesh getMesh() {
        return super.getMesh();
    }
}
