package btr.anchor.engine.util.fps;

public class FPS {

    public static float deltaTime;

    public static long lastStamp;

    public static double fps;

    public FPS() {
        lastStamp = System.currentTimeMillis();
    }

    public static void abc1() {
        long currentStamp = System.currentTimeMillis();
        deltaTime = lastStamp - currentStamp;
        fps = 1d / ((double) deltaTime / 1000d);
        lastStamp = System.currentTimeMillis();
    }

}