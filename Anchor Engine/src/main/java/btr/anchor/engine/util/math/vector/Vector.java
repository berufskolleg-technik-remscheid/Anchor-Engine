package btr.anchor.engine.util.math.vector;

import btr.anchor.engine.util.math.AnchorMathLibrary;

import java.util.Arrays;

public class Vector implements IVector, Cloneable {

    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;

    private double[] dimensions;

    public Vector(double... dimensions) {
        this.dimensions = dimensions;
    }

    public Vector(Vector vector) {
        this.dimensions = vector.dimensions.clone();
    }

    public double getMagnitude() {
        double result = 0;
        for (double x : dimensions) {
            result += x * x;
        }
        return AnchorMathLibrary.nthRoot(2, result);
    }

    public Vector normalize() {
        return this.div(this.getMagnitude());
    }

    public Vector getDifference(Vector second) {
        if (second.dimensions.length != dimensions.length)
            return null; // cant compute two different vectors TODO: Exception
        Vector v = new Vector();
        for (int i = 0; i < dimensions.length; i++) {
            v.dimensions[i] = dimensions[i] - second.dimensions[i];
        }
        return v;
    }

    public Vector mult(double multiplier) {
        for (int i = 0; i < dimensions.length; i++) {
            dimensions[i] *= multiplier;
        }
        return this;
    }

    public Vector div(double divisor) {
        return mult(1d / divisor);
    }

    public Vector add(Vector vector) {
        if (this.dimensions.length < vector.dimensions.length) {
            double temp[] = dimensions.clone();
            dimensions = vector.dimensions.clone();
            for (int i = 0; i < temp.length; i++) {
                dimensions[i] += temp[i];
            }
            return this;
        }
        for (int i = 0; i < vector.dimensions.length; i++) {
            dimensions[i] += vector.dimensions[i];
        }
        return this;
    }

    public Vector sub(Vector vector) {
        return this.add(vector.clone().mult(-1));
    }

    public double get(int dimension) {
        return dimensions[dimension];
    }

    public void set(Vector v) {
        this.dimensions = v.dimensions.clone();
    }

    @Override
    public String toString() {
        if (dimensions.length == 1) {
            return "x: " + dimensions[0];
        }
        if (dimensions.length == 2) {
            return "x: " + dimensions[0] + " y: " + dimensions[1];
        }
        if (dimensions.length == 3) {
            return "x: " + dimensions[0] + " y: " + dimensions[1] + " z: " + dimensions[2];
        }
        String result = "";
        for (int i = 0; i < dimensions.length; i++) {
            result += " x" + i + ": " + dimensions[i];
        }
        return result;
    }

    @Override
    public Vector clone() {
        return new Vector(dimensions.clone());
    }

    @Override
    public double[] getDimensions() {
        return dimensions;
    }

    @Override
    public double distanceTo(Vector vector) {
        return 0;
    }

    @Override
    public Vector zeroVector() {
        double[] zero = new double[dimensions.length];
        Arrays.fill(zero, 0);
        return new Vector(zero);
    }
}