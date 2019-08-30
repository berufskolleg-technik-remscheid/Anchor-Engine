package btr.anchor.engine.display.image;

import btr.anchor.engine.util.annotations.Unsupported;
import btr.anchor.engine.util.log.Logger;

public class DisplayImage {

    public int[][] pixels;
    public int width;
    public int height;

    public DisplayImage(int width, int height) {
        this.pixels = new int[width][height];
        this.height = height;
        this.width = width;
    }

    @Unsupported
    public int getRed(int x, int y) {
        return pixels[x][y];
    }

    @Unsupported
    public int getGreen(int x, int y) {
        return pixels[x][y];
    }

    @Unsupported
    public int getBlue(int x, int y) {
        return pixels[x][y];
    }

    public int getRGB(int x, int y) {
        return pixels[x][y];
    }

    public void setPixels(int[] colors) {
        if (colors.length != width * height) {
            Logger.error.send("Length of color array is not correct!");
            return;
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.pixels[x][y] = colors[width * y + x];
            }
        }
    }

    public void setPixels(int[][] pixels) {
        this.pixels = pixels.clone();
    }

    public int[] getColorArray() {
        int[] colors = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                colors[width * y + x] = pixels[x][y];
            }
        }
        return colors;
    }

    public void scale(int width, int height) {

        double xs = (double) pixels.length / width;
        double ys = (double) pixels[0].length / height;
        int[][] newPixels = new int[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                newPixels[x][y] = pixels[(int) (x * xs)][(int) (y * ys)];
            }
        }
        pixels = newPixels;
        System.out.println(width + " " + height);
        this.width = width;
        this.height = height;
    }

}
