package org.mrzebo.game.entities;

import java.awt.*;

/**
 * Created by Home on 14.08.17.
 */
public class Eagle extends Entity {
    public Eagle(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
