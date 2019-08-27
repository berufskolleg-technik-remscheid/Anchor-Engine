package btr.anchor.engine.util.objects.light;

import btr.anchor.engine.util.math.vector.Vector;

public abstract class LightObject implements ILight {

    Vector position;
    Vector direction;

    float radius;
    float strength;
}