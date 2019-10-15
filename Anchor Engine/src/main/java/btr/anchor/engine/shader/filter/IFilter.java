package btr.anchor.engine.shader.filter;

import btr.anchor.engine.display.image.DisplayImage;

public abstract class IFilter {

    protected abstract DisplayImage process(DisplayImage image);

    public abstract String getFilterName();

}