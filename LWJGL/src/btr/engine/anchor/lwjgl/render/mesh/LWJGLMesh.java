package btr.engine.anchor.lwjgl.render.mesh;

import btr.engine.anchor.bridge.object.mesh.Mesh;

public class LWJGLMesh {

    private int vao;
    private int[] vobs;

    public static LWJGLMesh fromMesh(Mesh mesh) {
        LWJGLMesh result = new LWJGLMesh();
        return result;
    }

}
