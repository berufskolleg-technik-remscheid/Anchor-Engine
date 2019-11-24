package btr.engine.anchor.lwjgl.opengl.render.mesh;

import btr.engine.anchor.bridge.math.Vector3f;
import btr.engine.anchor.bridge.object.mesh.Mesh;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class OpenGLMesh {

    private Vertex[] vertices;
    private int[] indices;
    int vao, pbo, ibo;

    public OpenGLMesh(Vertex[] vertices, int[] indices) {
        this.vertices = vertices;
        this.indices = indices;
    }

    public void create() {
        vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao);

        FloatBuffer positionBuffer = MemoryUtil.memAllocFloat(vertices.length * 3);
        float[] positionData = new float[vertices.length * 3];
        for (int i = 0; i < vertices.length; i++) {
            positionData[i * 3] = vertices[i].getPosition().getX();
            positionData[i * 3 + 1] = vertices[i].getPosition().getZ();
            positionData[i * 3 + 2] = vertices[i].getPosition().getX();
        }
        positionBuffer.put(positionData).flip();

        pbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, pbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, positionBuffer, GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
        indicesBuffer.put(indices).flip();

        ibo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL15.GL_STATIC_DRAW);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
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
        Vertex[] vertices = new Vertex[mesh.getVertices().length / mesh.getVERTEX_SIZE()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(new Vector3f(mesh.getVertices()[i], mesh.getVertices()[i * 3 + 1], mesh.getVertices()[i * 3 + 2]));
        }
        return new OpenGLMesh(vertices, mesh.getIndices());
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    public int getVao() {
        return vao;
    }

    public void setVao(int vao) {
        this.vao = vao;
    }

    public int getPbo() {
        return pbo;
    }

    public void setPbo(int pbo) {
        this.pbo = pbo;
    }

    public int getIbo() {
        return ibo;
    }

    public void setIbo(int ibo) {
        this.ibo = ibo;
    }
}
