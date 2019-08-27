package btr.anchor.engine.util.log.type;

public class Error implements Log {

    @Override
    public void send(String log) {
        System.out.println("[Error] " + log);
    }
}
