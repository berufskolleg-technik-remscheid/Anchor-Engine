package btr.anchor.engine.util.fps;

public class FPS {

    public static float deltaTime;

    public static long lastStamp;

    public static volatile int fps;

    public static int maxFPS;

    public FPS() {
        lastStamp = System.currentTimeMillis();
    }

    public static void update() {
        long currentStamp = System.currentTimeMillis();
        deltaTime = currentStamp - lastStamp;
        fps = (int) (1d / (deltaTime / 1000d));
        lastStamp = System.currentTimeMillis();
    }
}