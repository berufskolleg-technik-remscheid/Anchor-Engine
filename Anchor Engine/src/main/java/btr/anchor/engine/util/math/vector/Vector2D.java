package btr.anchor.engine.util.math.vector;

public class Vector2D implements IVector, Cloneable {

    public double x;
    public double y;

    public double[] dimension;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
        dimension = new double[2];
        dimension[0] = x;
        dimension[1] = y;
    }

    public Vector2D(double[] dimension) {
        this.dimension = dimension;
        this.x = dimension[0];
        this.y = dimension[1];
    }

    public double getX() {
        return dimension[0];
    }

    public double getY() {
        return dimension[1];
    }

    public IVector zeroVector() {
        return new Vector(0, 0);
    }

    public Vector2D zeroVector2D() {
        return new Vector2D(0, 0);
    }

    @Override
    public double distanceTo(Vector vector) {
        return 0;
    }

    @Override
    public double[] getDimentions() {
        return dimension;
    }


    @Override
    public Vector2D clone() {
        return new Vector2D(dimension.clone());
    }
}
