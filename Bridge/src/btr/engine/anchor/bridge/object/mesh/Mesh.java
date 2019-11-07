package btr.engine.anchor.bridge.object.mesh;

public class Mesh {

    public int VERTEX_SIZE = 3;
    protected float[] vertices;

    public Mesh(float[] vertices) {
        this.vertices = vertices;
    }

    public float[] getVertices() {
        return vertices;
    }

    public int getVERTEX_SIZE() {
        return VERTEX_SIZE;
    }
}