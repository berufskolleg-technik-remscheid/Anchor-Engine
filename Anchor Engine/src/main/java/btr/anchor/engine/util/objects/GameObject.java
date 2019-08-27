package btr.anchor.engine.util.objects;

import btr.anchor.engine.util.math.vector.IVector;
import btr.anchor.engine.util.math.vector.Vector;

public abstract class GameObject implements Movable {

    public IVector position;
    Vector direction;
    int mass;

    @Override
    public void move(IVector position) {
        this.position = position;
    }


}