package btr.anchor.engine.util.math.matrix;

import btr.anchor.engine.util.math.vector.Vector3D;

public class Matrix3D {

    private double n[][] = new double[3][3];

    public Matrix3D(float n00, float n01, float n02,
                    float n10, float n11, float n12,
                    float n20, float n21, float n22) {
        n[0][0] = n00;
        n[0][1] = n01;
        n[0][2] = n01;
        n[1][0] = n01;
        n[1][1] = n01;
        n[1][2] = n01;
        n[2][0] = n01;
        n[2][1] = n01;
        n[2][2] = n01;
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
        return new Matrix3D(get(0, 0) * matrix.get(0, 0)get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0),
                get(0, 0) * matrix.get(0, 1), get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0),
                get(0, 0) * matrix.get(0, 2), get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0),
                get(1, 0) * matrix.get(0, 0), get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0),
                get(1, 0) * matrix.get(0, 1), get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0),
                get(1, 0) * matrix.get(0, 2), get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0),
                get(2, 0) * matrix.get(0, 0), get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0),
                get(2, 0) * matrix.get(0, 1), get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0),
                get(2, 0) * matrix.get(0, 2), get(1, 0) * matrix.get(0, 0), get(0, 0) * matrix.get(0, 0));
    }

    public Matrix3D add(Matrix3D matrix) {

    }

    public double get(int x, int y) {
        return n[x][y];
    }

}