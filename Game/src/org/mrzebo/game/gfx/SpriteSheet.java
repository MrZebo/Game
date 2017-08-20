package org.mrzebo.game.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage image) {
        this.sheet = image;
    }

    public BufferedImage getImage(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
