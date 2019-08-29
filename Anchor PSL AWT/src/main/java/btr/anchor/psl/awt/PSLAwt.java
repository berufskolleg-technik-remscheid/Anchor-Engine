package btr.anchor.psl.awt;

import btr.anchor.engine.AnchorEngine;
import btr.anchor.engine.pidl.PlatformIndependenceLayer;
import btr.anchor.engine.util.fps.FPS;
import btr.anchor.psl.awt.out.*;
import btr.anchor.psl.awt.util.AWTSetting;
import btr.anchor.psl.awt.util.DisplayString;
import btr.anchor.psl.awt.util.ImageConverter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PSLAwt extends PlatformIndependenceLayer {

    public JFrame frame;
    public JPanel centerPanel;
    public JPanel northPanel = new JPanel();
    public JPanel westPanel = new JPanel();
    public JPanel eastPanel = new JPanel();
    public JPanel southPanel = new JPanel();

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
        awtSetting.scaleDown(2);
        frame = new JFrame();
    }

    public void init() {
        centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentImage == null) return;
                g.drawImage(ImageConverter.displayImageToBufferedImage(currentImage), 0, 0, null);
                g.setColor(Color.BLUE);
                g.setFont(new Font("Serif", Font.BOLD, 20));
                g.drawString("FPS: " + FPS.fps, 100, 100);
            }
        };
        frame.setSize(awtSetting.maxScreenSize);
        frame.setLayout(new BorderLayout(0, 0));

        centerPanel.setSize(frame.getSize());

        northPanel.setVisible(false);
        eastPanel.setVisible(false);
        westPanel.setVisible(false);
        southPanel.setVisible(false);


        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(southPanel, BorderLayout.SOUTH);

        try {
            frame.setIconImage(ImageIO.read(new File("./res/anchor_480_640.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(AnchorEngine.getInstance().APPNAME + " Version: " + AnchorEngine.getInstance().VERSION);
        frame.setResizable(false);
    }

    public void repaint() {
        centerPanel.repaint();
        frame.setVisible(true); // TODO: dis very shit
    }

}