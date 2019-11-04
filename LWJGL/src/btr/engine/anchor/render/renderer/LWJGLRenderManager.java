package btr.engine.anchor.render.renderer;

import btr.engine.anchor.LWJGLRenderLayer;
import btr.engine.anchor.bridge.object.AnchorObject;
import btr.engine.anchor.bridge.render.RenderManager;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class LWJGLRenderManager implements RenderManager {

    private LWJGLRenderLayer lwjgl;

    public LWJGLRenderManager(LWJGLRenderLayer lwjgl) {
        this.lwjgl = lwjgl;
    }

    @Override
    public int[] render(AnchorObject[] anchorObjects) {
        GL.createCapabilities();
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GLFW.glfwSwapBuffers(lwjgl.getWindow());
        GLFW.glfwPollEvents();
        int[] pixels = new int[lwjgl.getVidMode().width() * lwjgl.getVidMode().height() * 4];
        GL11.glReadBuffer(GL11.GL_FRONT);
        GL11.glReadPixels(0, 0, lwjgl.getVidMode().width(), lwjgl.getVidMode().height(), GL11.GL_RGBA, GL11.GL_UNSIGNED_INT, pixels);
        return pixels; // TODO: return rendered image
    }
}