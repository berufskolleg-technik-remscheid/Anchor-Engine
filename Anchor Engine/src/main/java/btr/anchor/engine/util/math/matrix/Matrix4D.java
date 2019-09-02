package btr.anchor.engine.util.math.matrix;

public class Matrix4D implements Cloneable {

    private double[][] n = new double[4][4];

    public Matrix4D(Matrix4D matrix) {
        n = matrix.n.clone();
    }

    public Matrix4D(double[][] n) {
        this.n = n.clone();
    }

    @Override
    protected Matrix4D clone() throws CloneNotSupportedException {
        return new Matrix4D(n.clone());
    }
}