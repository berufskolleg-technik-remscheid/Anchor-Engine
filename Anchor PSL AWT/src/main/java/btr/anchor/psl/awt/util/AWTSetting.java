package btr.anchor.psl.awt.util;

import java.awt.*;

public class AWTSetting {

    public Dimension maxScreenSize;

    public AWTSetting() {
        this.maxScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public void scaleUp(int amount) {
        this.maxScreenSize = new Dimension(maxScreenSize.width * amount, maxScreenSize.width * amount);
    }

    public void scaleDown(int amount) {
        this.maxScreenSize = new Dimension(maxScreenSize.width / amount, maxScreenSize.width / amount);
    }

}