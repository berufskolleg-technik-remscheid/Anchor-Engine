package btr.engine.anchor.bridge.object.mesh;

public class Mesh2D extends Mesh {

    public Mesh2D(float[] vertices, int[] indices) {
        super(vertices, indices);
        VERTEX_SIZE = 2;
    }
}