package btr.anchor.engine.util.math.physic;

import btr.anchor.engine.util.math.vector.Vector;

public class Square extends Shape {

    public Square() {
        indicies[0] = new Vector(0, 0);
        indicies[1] = new Vector(0, 1);
        indicies[2] = new Vector(1, 0);
        indicies[3] = new Vector(1, 1);
    }

    public boolean isInside(Vector index, Vector distance) {
        return (index.get(Vector.X) + distance.get(Vector.X) < 1 && index.get(Vector.X) + distance.get(Vector.X) > 0 &&
                index.get(Vector.Y) + distance.get(Vector.Y) < 1 && index.get(Vector.Y) + distance.get(Vector.Y) > 0);
    }

    @Override
    public boolean collidesWith(Shape shape, Vector distance) {
        for (Vector index : shape.indicies) {
            if (isInside(index, distance)) return true;
        }
        return false;
    }
}