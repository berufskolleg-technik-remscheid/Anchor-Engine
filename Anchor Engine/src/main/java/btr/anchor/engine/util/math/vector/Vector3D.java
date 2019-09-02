package btr.anchor.engine.util.math.vector;

public class Vector3D implements IVector, Cloneable {

    public double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double[] getDimentions() {
        return new double[]{x, y, z};
    }

    @Override
    public double distanceTo(Vector vector) {
        return 0;
    }

    @Override
    public IVector zeroVector() {
        return null;
    }
}
