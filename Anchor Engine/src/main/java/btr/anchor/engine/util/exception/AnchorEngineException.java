package btr.anchor.engine.util.exception;

public class AnchorEngineException extends RuntimeException {

    protected boolean critical;

    public AnchorEngineException(boolean critical) {
        this.critical = critical;
    }

    public AnchorEngineException() {
        this.critical = false;
    }

    public boolean isCritical() {
        return critical;
    }
}