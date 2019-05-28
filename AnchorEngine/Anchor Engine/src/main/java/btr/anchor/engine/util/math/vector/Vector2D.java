package btr.anchor.engine.util.math.vector;

public class Vector2D implements IVector {

    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static Vector2D zeroVector() {
        return new Vector2D(0, 0);
    }

}
