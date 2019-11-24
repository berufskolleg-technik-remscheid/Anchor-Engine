package btr.engine.anchor.lwjgl.opengl.render.renderer;

import btr.engine.anchor.bridge.object.AnchorObject;
import btr.engine.anchor.bridge.object.mesh.Mesh;
import btr.engine.anchor.bridge.render.RenderManager;
import btr.engine.anchor.lwjgl.opengl.OpenGLRenderLayer;
import btr.engine.anchor.lwjgl.opengl.render.mesh.OpenGLMesh;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class OpenGLRenderManager implements RenderManager {

    private OpenGLRenderLayer lwjgl;

    public OpenGLRenderManager(OpenGLRenderLayer lwjgl) {
        this.lwjgl = lwjgl;
    }

    @Override
    public void init() {
        
    }

    @Override
    public int[] render(AnchorObject[] anchorObjects) {
        GL.createCapabilities();
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GLFW.glfwSwapBuffers(lwjgl.getWindow());
        // render things in here
        OpenGLMesh[] meshs = new OpenGLMesh[anchorObjects.length];
        for (int i = 0; i < anchorObjects.length; i++) {
            OpenGLMesh mesh = meshs[i] = OpenGLMesh.fromMesh(anchorObjects[i].getMesh());
            GL30.glBindVertexArray(mesh.getVao());
            GL30.glEnableVertexAttribArray(0);
            GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, mesh.getIbo());
            GL11.glDrawElements(GL11.GL_TRIANGLES, mesh.getIndices().length, GL11.GL_FLOAT, 0);
            GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
            GL30.glDisableVertexAttribArray(0);
            GL30.glBindVertexArray(0);
        }
        GLFW.glfwPollEvents();
        int[] pixels = new int[lwjgl.getVidMode().width() * lwjgl.getVidMode().height() * 4];
        GL11.glReadBuffer(GL11.GL_FRONT);
        GL11.glReadPixels(0, 0, lwjgl.getVidMode().width(), lwjgl.getVidMode().height(), GL11.GL_RGBA, GL11.GL_UNSIGNED_INT, pixels);
        return pixels;
    }
}