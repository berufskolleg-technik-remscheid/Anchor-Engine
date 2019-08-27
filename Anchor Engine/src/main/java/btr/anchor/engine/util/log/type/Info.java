package btr.anchor.engine.util.log.type;

public class Info implements Log {

    @Override
    public void send(String log) {
        System.out.println("[INFO] " + log);
    }
}
