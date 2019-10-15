package btr.anchor.engine.util.objects.objects.twod;

import btr.anchor.engine.util.math.vector.IVector;
import btr.anchor.engine.util.objects.GameObject;

public class Square extends GameObject {

    public Square(IVector position) {
        super(position);
        vertices[0][0][0] = 1;
        vertices[0][1][0] = 1;
        vertices[1][0][0] = 1;
        vertices[1][1][0] = 1;
    }
}