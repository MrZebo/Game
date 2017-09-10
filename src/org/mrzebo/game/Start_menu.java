package org.mrzebo.game;

import org.mrzebo.game.gfx.Assets;
import org.mrzebo.game.gfx.ImageLoader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by MrZebo on 09.09.2017.
 */
public class Start_menu implements KeyListener {
    private Image image;
    private Cursor cursor;
    private Game game;

    public Start_menu(Game game) {
        image = ImageLoader.loadImage("/battle-city.png");
        cursor = new Cursor();
        this.game = game;
    }


    public void render(Graphics g) {
        g.drawImage(image, 0, 0, null);
        cursor.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                if (cursor.statement) {
                    cursor.setY(335);
                    cursor.setStatement(false);
                    cursor.randomImage();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!cursor.statement) {
                    cursor.setY(375);
                    cursor.setStatement(true);
                    cursor.randomImage();
                }
                break;
            case KeyEvent.VK_ENTER:
                game.setStatement(STATEMENT.GAME);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private class Cursor {
        private Image image;
        private Image imageYellow;
        private Image imageGreen;
        private Image imageRed;
        private Image imageSilver;
        private Image[] images;
        volatile boolean statement;
        private int x;
        private int y;

        public void setStatement(boolean statement) {
            this.statement = statement;
        }

        public void setY(int y) {
            this.y = y;
        }

        Cursor() {
            statement = false;
            imageYellow = Assets.getCursorYellow();
            imageGreen = Assets.getCursorGreen();
            imageRed = Assets.getCursorRed();
            imageSilver = Assets.getCursorSilver();
            images = new Image[]{imageYellow, imageSilver, imageRed, imageGreen};
            randomImage();
            x = 205;
            y = 335;

        }

        private void randomImage() {
            int r = (int) (Math.random() * 4);
            image = images[r];
        }

        private void render(Graphics g) {
            g.drawImage(image, x, y, null);
        }
    }
}
