package org.mrzebo.game.entities;

import org.mrzebo.game.gfx.Assets;

import java.awt.*;

/**
 * Created by Home on 14.08.17.
 */
public class Eagle extends Entity {
    private Image image;

    public Eagle(int x, int y, int width, int height) {
        super(x, y, width, height);
        image = Assets.getEagle();
        life = 1;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
