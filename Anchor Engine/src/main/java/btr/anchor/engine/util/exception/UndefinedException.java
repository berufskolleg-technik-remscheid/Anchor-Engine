package btr.anchor.engine.util.exception;

public class UndefinedException extends AnchorEngineException {

    public UndefinedException() {
        super(false);
    }

    public UndefinedException(boolean critical) {
        super(critical);
    }
}
