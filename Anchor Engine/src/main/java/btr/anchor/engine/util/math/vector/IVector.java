package btr.anchor.engine.util.math.vector;

public interface IVector {

    double[] getDimentions();

    double distanceTo(Vector vector);

    IVector zeroVector();

}