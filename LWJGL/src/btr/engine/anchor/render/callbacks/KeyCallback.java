package btr.engine.anchor.render.callbacks;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyCallback extends GLFWKeyCallback {

    public static boolean[] keys = new boolean[65536];

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = action != GLFW.GLFW_RELEASE;
    }
}