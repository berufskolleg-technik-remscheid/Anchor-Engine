package btr.anchor.engine.util.math.matrix;

import btr.anchor.engine.util.annotations.Unsupported;
import btr.anchor.engine.util.math.vector.Vector3D;

public class Matrix3D implements Cloneable {

    private double[][] n = new double[3][3];

    public Matrix3D(Matrix3D matrix) {
        n = matrix.n.clone();
    }

    public Matrix3D(double[][] n) {
        this.n = n;
    }

    public Matrix3D(double n00, double n01, double n02,
                    double n10, double n11, double n12,
                    double n20, double n21, double n22) {
        n[0][0] = n00;
        n[0][1] = n01;
        n[0][2] = n02;
        n[1][0] = n10;
        n[1][1] = n11;
        n[1][2] = n12;
        n[2][0] = n20;
        n[2][1] = n21;
        n[2][2] = n22;
    }

    public Matrix3D(Vector3D a, Vector3D b, Vector3D c) {
        n[0][0] = a.x;
        n[0][1] = a.y;
        n[0][2] = a.z;
        n[1][0] = b.x;
        n[1][1] = b.y;
        n[1][2] = b.z;
        n[2][0] = c.x;
        n[2][1] = c.y;
        n[2][2] = c.z;
    }

    public Matrix3D multiply(Matrix3D matrix) {
        return new Matrix3D(get(0, 0) * matrix.get(0, 0) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0),
                get(0, 0) * matrix.get(0, 1) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0),
                get(0, 0) * matrix.get(0, 2) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0),
                get(1, 0) * matrix.get(0, 0) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0),
                get(1, 0) * matrix.get(0, 1) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0),
                get(1, 0) * matrix.get(0, 2) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0),
                get(2, 0) * matrix.get(0, 0) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0),
                get(2, 0) * matrix.get(0, 1) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0),
                get(2, 0) * matrix.get(0, 2) + get(1, 0) * matrix.get(0, 0) + get(0, 0) * matrix.get(0, 0));
    }

    @Unsupported
    public Matrix3D add(Matrix3D matrix) {
        return null;
    }

    public double get(int x, int y) {
        return n[x][y];
    }

    @Override
    protected Matrix3D clone() throws CloneNotSupportedException {
        return new Matrix3D(n.clone());
    }
}