package org.mrzebo.game.entities;

import java.awt.*;

public class Buff extends Entity {
    private boolean blink;

    public Buff(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
        blink = true;
    }

    @Override
    public void tick() {
        if (blink) {
            blink = false;
        } else {
            blink = true;
        }
    }

    @Override
    public void render(Graphics g) {
        if(blink){
            g.drawImage(image, x, y, null);
        }
    }
}
