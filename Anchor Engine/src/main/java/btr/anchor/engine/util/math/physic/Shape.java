package btr.anchor.engine.util.math.physic;

import btr.anchor.engine.util.math.vector.Vector;

public abstract class Shape {

    public Vector indicies[] = new Vector[4];

    public abstract boolean collidesWith(Shape shape, Vector distance);

}
