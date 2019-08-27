package btr.anchor.engine.util.math;

public class Dimension {

    int width;
    int height;

    public Dimension() {
        this.width = 0;
        this.height = 0;
    }

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getSurface() {
        return width * height;
    }

    public void setDimension(Dimension d) {
        this.height = d.height;
        this.width = d.width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}