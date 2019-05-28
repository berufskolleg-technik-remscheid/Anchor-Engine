package btr.anchor.engine.util.math.vector;

public abstract class Vector {

    float[] dimensions;

    public Vector(float... dimensions) {
        this.dimensions = dimensions;
    }
}