package btr.anchor.engine.util.objects;

import btr.anchor.engine.util.math.vector.IVector;
import btr.anchor.engine.util.math.vector.Vector;

public abstract class GameObject implements Movable {

    public IVector position;
    public Vector direction = new Vector().zeroVector();
    public int mass = 100;
    protected int[][][] vertices;

    public GameObject(IVector position) {
        this.position = position;
    }

    public GameObject(IVector position, int mass) {
        this.position = position;
        this.mass = mass;
    }

    public GameObject(IVector position, Vector direction) {
        this.position = position;
        this.direction = direction;
    }

    public GameObject(IVector position, Vector direction, int mass) {
        this.position = position;
        this.direction = direction;
        this.mass = mass;
    }

    @Override
    public void move(IVector position) {
        this.position = position;
    }
}