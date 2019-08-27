package btr.anchor.engine.util.log.type;

public class Debug implements Log {
    @Override
    public void send(String log) {
        System.out.println("[DEBUG] " + log);
    }
}
