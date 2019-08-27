package btr.anchor.engine.util.exception;

public class MathException extends AnchorEngineException {

    public MathException() {
        super(true);
    }

    public MathException(boolean critical) {
        super(critical);
    }
}