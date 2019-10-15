package btr.anchor.engine.util.math.vector;

public interface IVector {

    double[] getDimensions();

    double distanceTo(Vector vector);

    IVector zeroVector();

}