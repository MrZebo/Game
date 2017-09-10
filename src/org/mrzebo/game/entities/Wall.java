package org.mrzebo.game.entities;

import org.mrzebo.game.gfx.Assets;

import java.awt.*;

public class Wall extends Entity {
    private Image image;

    public Wall(int x, int y, int width, int height) {
        super(x, y, width, height);
        image = Assets.getFullWall();
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
                    switch (getDirection()) {
                        case UP:
//                            setImage(Assets.getUpHalfWall());
                            image = Assets.getUpHalfWall();
                            g.drawImage(image, x, y, null);
                            break;
                        case DOWN:
//                            setImage(Assets.getDownHalfWall());
                            image = Assets.getDownHalfWall();
                            g.drawImage(image, x, y + 8, null);
                            break;
                        case RIGHT:
//                            setImage(Assets.getRightHalfWall());
//                            setImage(Assets.getLeftHalfWall());
                            image = Assets.getRightHalfWall();
                            g.drawImage(image, x + 8, y, null);
                            break;
                        case LEFT:
//                            setImage(Assets.getLeftHalfWall());
                            image = Assets.getLeftHalfWall();
                            g.drawImage(image, x, y, null);
                            break;
                    }
                    break;
                case (0):
                    setNotShot(false);
                    break;
                default:
                    setNotShot(false);
                    break;
            }
        }
    }
}
