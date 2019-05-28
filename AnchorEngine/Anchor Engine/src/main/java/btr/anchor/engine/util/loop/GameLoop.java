package btr.anchor.engine.util.loop;

public class GameLoop {

    int maxFramerate; // 0 is unlimited

    boolean run;

    public GameLoop() {

    }

    public GameLoop(int maxFramerate) {
        this.maxFramerate = maxFramerate;
        this.run = true;
    }

    public void start() {
        while (run) {

        }
    }
}