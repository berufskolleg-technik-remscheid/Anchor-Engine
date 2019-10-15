package btr.anchor.engine.shader.filter;

import btr.anchor.engine.display.image.DisplayImage;
import btr.anchor.engine.util.log.Logger;

import java.util.ArrayList;

public class FilterHandler {

    private ArrayList<IFilter> filters = new ArrayList<>();

    public void registerFilter(IFilter filter) {
        filters.add(filter);
    }

    public void unregisterFilter(IFilter filter) {
        filters.remove(filter);
    }

    public DisplayImage run(DisplayImage image) {
        for (IFilter filter : filters) {
            image = filter.process(image);
            Logger.info.send(filter.getFilterName() + " processed");
        }
        return image;
    }
}