package btr.engine.anchor.lwjgl.opengl.render.mesh;

import btr.engine.anchor.bridge.math.Vector3f;

public class Vertex {

    private Vector3f position;

    public Vertex(Vector3f position) {
        this.position = position;
    }

    public Vector3f getPosition() {
        return position;
    }
}