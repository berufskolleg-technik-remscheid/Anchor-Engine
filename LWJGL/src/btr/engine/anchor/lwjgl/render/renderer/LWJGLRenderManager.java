package btr.engine.anchor.lwjgl.render.renderer;

import btr.engine.anchor.bridge.object.AnchorObject;
import btr.engine.anchor.bridge.render.RenderManager;
import btr.engine.anchor.lwjgl.LWJGLRenderLayer;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

public class LWJGLRenderManager implements RenderManager {

    private LWJGLRenderLayer lwjgl;

    private float positions[] = {
            0.5f, 0.6f, 0.0f,
            0.04f, 0.1f, 0.5f,
            0.1f, 0.6f, 1f
    };

    public LWJGLRenderManager(LWJGLRenderLayer lwjgl) {
        this.lwjgl = lwjgl;
    }

    @Override
    public void init() {
        FloatBuffer buffer = MemoryUtil.memAllocFloat(positions.length);
        buffer
        GL15.glGenBuffers(buffer);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, buffer);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, positions.length, positions, GL15.GL_STATIC_DRAW);
    }

    @Override
    public int[] render(AnchorObject[] anchorObjects) {
        GL.createCapabilities();
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GLFW.glfwSwapBuffers(lwjgl.getWindow());
        // render things in here
        GLFW.glfwPollEvents();
        int[] pixels = new int[lwjgl.getVidMode().width() * lwjgl.getVidMode().height() * 4];
        GL11.glReadBuffer(GL11.GL_FRONT);
        GL11.glReadPixels(0, 0, lwjgl.getVidMode().width(), lwjgl.getVidMode().height(), GL11.GL_RGBA, GL11.GL_UNSIGNED_INT, pixels);
        return pixels;
    }
}