package btr.anchor.engine.util.math.physic;

import btr.anchor.engine.util.math.vector.Vector;

public interface PhysicsObject {

    Vector mass = new Vector(1);
    Vector acceleration = new Vector(0, 0);
    Vector velocity = new Vector(0, 0);
    Vector position = new Vector(0, 0);
    boolean isStatic = false;
    Shape shape = new Square();


}