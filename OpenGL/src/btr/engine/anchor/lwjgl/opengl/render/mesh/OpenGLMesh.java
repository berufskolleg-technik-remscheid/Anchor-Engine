package btr.engine.anchor.lwjgl.opengl.render.mesh;

import btr.engine.anchor.bridge.object.mesh.Mesh;

public class OpenGLMesh {

    private int vao;
    private int[] vobs;

    public static OpenGLMesh fromMesh(Mesh mesh) {
        OpenGLMesh result = new OpenGLMesh();
        return result;
    }

}
