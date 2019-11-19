package btr.engine.anchor.lwjgl.opengl.render.mesh;

import btr.engine.anchor.bridge.object.mesh.Mesh;

public class OpenGLMesh {

    private Vertex[] vertices;
    private int[] indices;

    public OpenGLMesh(Vertex[] vertices, int[] indices) {
        this.vertices = vertices;
        this.indices = indices;
    }

    public void create() {

    }

    public void remove() {
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    public static OpenGLMesh fromMesh(Mesh mesh) {
        return new OpenGLMesh(null, null);
    }
}
