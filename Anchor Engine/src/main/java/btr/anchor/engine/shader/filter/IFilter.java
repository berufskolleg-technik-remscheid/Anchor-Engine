package btr.anchor.engine.shader.filter;

import btr.anchor.engine.display.image.DisplayImage;

public interface IFilter {

    DisplayImage process(DisplayImage image);

}