package org.mrzebo.game.display;

import org.mrzebo.game.levels.Level;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Level level;
    private Canvas canvas;
    private int width;
    private int height;
    private String title;

    public Display(Level level, String title, int width, int height) {
        this.level = level;
        this.width = width;
        this.height = height;
        this.title = title;
        canvas = level.getCanvas();
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        Dimension dimension = new Dimension(width, height);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setFocusable(true);
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);
        frame.add(canvas);
        frame.pack();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
