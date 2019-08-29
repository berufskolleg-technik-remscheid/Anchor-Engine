package btr.anchor.engine.util.color;

public class Color {

    int r, g, b, a;
    // red green blue alpha

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
    }

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public int getRed() {
        return r;
    }

    public int getGreen() {
        return g;
    }

    public int getBlue() {
        return b;
    }

    public int getAlpha() {
        return a;
    }

    public int getRGB() {
        return (r << 16 | g << 8 | b);
    }

    public int getRGBA() {
        return a << 24 | r << 16 | g << 8 | b;
    }

    public static int toRGB(int red, int green, int blue) {
        return red << 16 | green << 8 | blue;
    }

    public static int toRGBA(int red, int green, int blue, int alpha) {
        return alpha << 24 | red << 16 | green << 8 | blue;
    }

    public static int[] fromRGB(int rgb) {
        int[] a = new int[3];
        a[2] = (rgb >> 16) & 0x0FF;
        a[1] = (rgb >> 8) & 0x0FF;
        a[0] = (rgb) & 0x0FF;
        return a;
    }

    public static int[] fromRGBA(int rgba) {
        int[] a = new int[4];
        a[0] = (rgba >> 16) & 0x0FF;
        a[1] = (rgba >> 8) & 0x0FF;
        a[2] = (rgba) & 0x0FF;
        a[3] = (rgba >> 24) & 0x0FF;
        return a;
    }

    public enum Colors {

        RED(new Color(255, 0, 0)), GREEN(new Color(0, 255, 0)), BLUE(new Color(0, 0, 255));

        public Color color;

        Colors(Color color) {
            this.color = color;
        }
    }

}