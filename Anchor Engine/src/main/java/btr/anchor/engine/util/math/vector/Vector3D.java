package btr.anchor.engine.util.math.vector;

public class Vector3D implements IVector, Cloneable {

    int x, y, z;

    public Vector3D(int x, int y, int z) {
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
