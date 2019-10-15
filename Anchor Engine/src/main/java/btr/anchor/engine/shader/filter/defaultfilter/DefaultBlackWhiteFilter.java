package btr.anchor.engine.shader.filter.defaultfilter;

import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.shader.filter.IFilter;

public class DefaultBlackWhiteFilter extends IFilter {

    private DisplayImage processed;

    private float threshold = 127.5f;

    @Override
    public DisplayImage process(DisplayImage image) {
        int[][] pixels = new int[image.width][image.height];
        for (int y = 0; y < image.width; y++) {
            for (int x = 0; x < image.width; x++) {
                pixels[x][y] = image.pixels[x][y] > threshold ? 255 : 0;
            }
        }
        processed = new DisplayImage(image.width, image.height);
        processed.pixels = pixels;
        return processed;
    }

    @Override
    public String getFilterName() {
        return "DefaultBlackWhite";
    }

    public DisplayImage getProcessed() {
        return processed;
    }

    public float getThreshold() {
        return threshold;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }
}