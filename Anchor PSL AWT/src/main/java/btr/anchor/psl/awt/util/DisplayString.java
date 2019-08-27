package btr.anchor.psl.awt.util;

import btr.anchor.engine.util.color.Color;

public class DisplayString {

    public Color color;
    public String string;
    public int x;
    public int y;

    public DisplayString(String string, int x, int y, Color color) {
        this.color = color;
        this.string = string;
        this.x = x;
        this.y = y;
    }
}