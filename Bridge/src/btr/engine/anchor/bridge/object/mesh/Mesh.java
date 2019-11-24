package btr.engine.anchor.bridge.object.mesh;

public class Mesh {

    public int VERTEX_SIZE = 3;
    protected float[] vertices;
    protected int[] indices;

    public Mesh(float[] vertices, int[] indices) {
        this.vertices = vertices;
        this.indices = indices;
    }

    public float[] getVertices() {
        return vertices;
    }

    public int[] getIndices() {
        return indices;
    }

    public int getVERTEX_SIZE() {
        return VERTEX_SIZE;
    }
}