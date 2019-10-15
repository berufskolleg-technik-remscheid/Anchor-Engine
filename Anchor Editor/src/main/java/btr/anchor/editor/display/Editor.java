package btr.anchor.editor.display;

import btr.anchor.engine.AnchorEngine;
import btr.anchor.engine.util.enums.ReleaseState;
import btr.anchor.engine.util.enums.TargetSystem;
import btr.anchor.engine.util.log.Logger;
import btr.anchor.psl.awt.PSLAwt;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Editor {

    public AnchorEngine engine;

    PSLAwt layer;

    JFrame frame;
    JPanel panel;
    JPanel west;
    JPanel north;

    public void init() {
        engine = new AnchorEngine(TargetSystem.PC, "Anchor Engine Editor", 0.01, ReleaseState.ALPHA, false);
        if (engine.pidl instanceof PSLAwt) {
            layer = (PSLAwt) engine.pidl;
            frame = layer.frame;
            panel = layer.centerPanel;
            north = layer.northPanel;
            west = layer.westPanel;

            north.setLayout(new FlowLayout(FlowLayout.LEFT));
            JMenuBar bar = new JMenuBar();

            JMenu file = new JMenu("File");
            JMenu edit = new JMenu("Edit");
            JMenu help = new JMenu("Help");

            JMenuItem neu = new JMenuItem("Neu");
            JMenuItem save = new JMenuItem("Speicher");
            JMenuItem open = new JMenuItem("Öffnen");
            JMenuItem eat = new JMenuItem("Essen");
            JMenuItem close = new JMenuItem("Schließen");

            file.add(neu);
            file.add(save);
            file.add(open);
            file.add(eat);
            file.add(close);

            bar.add(file);
            bar.add(edit);
            bar.add(help);

            north.setVisible(true);
            north.add(bar);

            DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
            DefaultMutableTreeNode items = new DefaultMutableTreeNode("items");
            DefaultMutableTreeNode objects = new DefaultMutableTreeNode("objects");

            root.add(items);
            root.add(objects);

            west.setVisible(true);
            west.add(new JScrollPane(new JTree(root)));

        } else {
            Logger.error.send("The Editor cannot start on this Platform(" + engine.TARGETSYSTEM.independenceLayerType.name() + ")");
            return;
        }
    }
}