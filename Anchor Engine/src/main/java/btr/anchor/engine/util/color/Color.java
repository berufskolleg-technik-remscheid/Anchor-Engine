package btr.anchor.engine.util.color;

public class Color {

    int r, g, b;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
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

    public int getRGB() {
        return (r << 16 | g << 8 | b);
    }

    public static int toRGB(int red, int green, int blue) {
        return red << 16 | green << 8 | blue;
    }

    public static int[] fromRGB(int rgb) {
        int[] a = new int[3];
        a[0] = (rgb >> 16) & 0x0FF;
        a[1] = (rgb >> 8) & 0x0FF;
        a[0] = (rgb) & 0x0FF;
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