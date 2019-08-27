package btr.anchor.engine.scripting;

import btr.anchor.engine.util.math.vector.Vector3D;
import btr.anchor.engine.util.objects.GameObject;

public abstract class GameBehavior {

    public GameObject gameObject;
    public Vector3D location;

    public abstract void start();

    public abstract void tick();

}