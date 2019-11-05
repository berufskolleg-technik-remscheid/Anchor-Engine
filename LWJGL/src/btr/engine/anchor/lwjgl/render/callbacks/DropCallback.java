package btr.engine.anchor.lwjgl.render.callbacks;

import btr.engine.anchor.lwjgl.LWJGLRenderLayer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.system.MemoryUtil;

public class DropCallback extends GLFWDropCallback {

    LWJGLRenderLayer renderLayer;

    public DropCallback(LWJGLRenderLayer renderLayer) {
        this.renderLayer = renderLayer;
    }

    @Override
    public void invoke(long window, int count, long names) {
        String[] files = new String[count];
        PointerBuffer pointerBuffer = MemoryUtil.memPointerBuffer(names, count);
        for (int i = 0; i < count; i++) {
            files[i] = MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(pointerBuffer.get(i)));
        }
    }
}
