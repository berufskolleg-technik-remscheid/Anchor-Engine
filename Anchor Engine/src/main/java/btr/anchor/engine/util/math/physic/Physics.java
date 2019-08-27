package btr.anchor.engine.util.math.physic;

import btr.anchor.engine.util.math.vector.Vector;

import java.util.ArrayList;

public class Physics {

    public static Physics instance;
    ArrayList<PhysicsObject> objects;
    Vector gravity;

    public Physics(double gravity) {
        instance = this;
        this.gravity = new Vector(0, gravity);
    }

    public void addObject(PhysicsObject o) {
        objects.add(o);
    }

    private void applyForce(Vector Force, PhysicsObject object) {
        //F=m*a => a=F/m
        object.acceleration.set(Force.div(object.mass.get(Vector.X)));
        object.velocity.add(object.acceleration);
        object.position.add(object.velocity);
    }

    /**
     * one step through time<br />
     * very insufficient BigO equals n<sup>3</sup>
     */
    public void step() {
        //calculate Forces for every Object
        //F=m*a
        ArrayList<Vector> forces = new ArrayList<Vector>();
        for (PhysicsObject object : objects) {
            Vector force = new Vector(0, 0);
            if (!object.isStatic) {
                forces.add(gravity);
                for (PhysicsObject other : objects) {
                    Vector distance = other.position.clone().sub(object.position);
                    if (object.shape.collidesWith(other.shape, distance)) {
                        force.add(other.acceleration.clone().mult(other.mass.get(Vector.X)));
                    }
                }
            }
            forces.add(force);
        }
        for (int i = 0; i < forces.size(); i++) {
            applyForce(forces.get(i), objects.get(i));
        }
    }
}
