package btr.anchor.psl.awt.out;

import btr.anchor.bridge.output.IDisplaySettingsOut;
import btr.anchor.engine.util.math.Dimension;
import btr.anchor.psl.awt.PSLAwt;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplaySettingsOut implements IDisplaySettingsOut {

    private Frame frame;
    private Robot robot;

    public DisplaySettingsOut() {
        try {
            robot = new Robot();
            frame = PSLAwt.instance.frame;
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hideMouse() {
        frame.setCursor(frame.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
    }

    @Override
    public void showMouse() {
        frame.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void lockMouseInCenter() {
        robot.mouseMove(frame.getX() / 2, frame.getY() / 2);
    }

    @Override
    public void unlockMouseInCenter() {

    }
}