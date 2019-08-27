package btr.anchor.psl.awt.util;

import java.awt.*;

public class AWTSetting {

    public Dimension maxScreenSize;

    public AWTSetting() {
        this.maxScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }
}