package btr.anchor.psl.awt;

import btr.anchor.engine.pidl.PlatformIndependenceLayer;
import btr.anchor.engine.util.debug.DebugHelper;
import btr.anchor.engine.util.fps.FPS;
import btr.anchor.engine.util.settings.DisplaySettings;
import btr.anchor.psl.awt.out.*;
import btr.anchor.psl.awt.util.AWTSetting;
import btr.anchor.psl.awt.util.DisplayString;
import btr.anchor.psl.awt.util.ImageConverter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PSLAwt extends PlatformIndependenceLayer {

    public JFrame frame;
    public JPanel panel;

    public volatile ArrayList<DisplayString> displayStrings = new ArrayList<>();

    public static PSLAwt instance;

    private AWTSetting awtSetting;

    public PSLAwt() {
        instance = this;
        awtSetting = new AWTSetting();
        audioOut = new AudioOut();
        displayOut = new DisplayOut();
        fileOut = new FileOut();
        soundOut = new SoundOut();
        displaySettingsOut = new DisplaySettingsOut();
        frame = new JFrame();
    }

    public void init() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentImage == null) return;
                g.drawImage(ImageConverter.displayImageToBufferedImage(DebugHelper.generateRandomNoiseImage(getWidth(), getHeight())), 0, 0, null);
                g.setColor(Color.BLUE);
                g.setFont(new Font("Serif", Font.BOLD, 20));
                g.drawString("FPS: " + FPS.fps, 100, 100);
            }
        };
        panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(DisplaySettings.width, DisplaySettings.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void repaint() {
        panel.repaint();
    }

}