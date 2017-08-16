package org.mrzebo.game.entities;

import org.mrzebo.game.gfx.Assets;

import java.awt.*;

public class Wall extends Entity {

    public Wall(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);

    }

    @Override
    public void tick() {

    }


    @Override
    public void render(Graphics g) {
        if (isNotShot) {
            switch (getLife()) {
                case (2):
                    g.drawImage(image, x, y, null);
                    break;
                case (1):
//                    if (getDirection().equals(DIRECTION.DOWN)|| getDirection().equals(DIRECTION.UP)) {
//                        setImage(Assets.getUpHalfWall());
//                        g.drawImage(image, x, y, null);
//                    }
//                    if (getDirection().equals(DIRECTION.LEFT)|| getDirection().equals(DIRECTION.RIGHT)) {
//                        setImage(Assets.getLeftHalfWall());
//                        g.drawImage(image, x, y, null);
//                    }
                    switch (getDirection()) {
                        case UP:
                            setImage(Assets.getUpHalfWall());
                            g.drawImage(image, x, y, null);
                            break;
                        case DOWN:
                            setImage(Assets.getDownHalfWall());
                            g.drawImage(image, x, y + 8, null);
                            break;
                        case RIGHT:
                            setImage(Assets.getRightHalfWall());
                            g.drawImage(image, x, y, null);
                            break;
                        case LEFT:
                            setImage(Assets.getLeftHalfWall());
                            g.drawImage(image, x, y, null);
                            break;
                    }
                    break;
                case (0):
                    setNotShot(false);
                    break;
            }
        }
    }
}
