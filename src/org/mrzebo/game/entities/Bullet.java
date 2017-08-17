package org.mrzebo.game.entities;

import org.mrzebo.game.DIRECTION;
import org.mrzebo.game.entities.units.AbstractUnit;
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.entities.units.Player;
import org.mrzebo.game.gfx.Assets;

import java.awt.*;

public class Bullet extends Entity {
    private AbstractUnit unit;
    private boolean drawable = true;

    public Bullet(AbstractUnit unit, Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
        this.unit = unit;
        setDirection(unit.getDirection());
    }

    boolean isDrawable() {
        return drawable;
    }

    private void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public void isShot(int x, int y) {
        for (Entity entity : unit.getGame().getLevel().getEntities()) {
            if (entity.getX() == x && entity.getY() == y || (entity.getX() - 5 == x && entity.getY() - 5 == y || entity.getX() + 5 == x && entity.getY() + 5 == y)) {
                switch (unit.direction) {
                    case UP:
                        entity.setDirection(DIRECTION.UP);
                        break;
                    case DOWN:
                        entity.setDirection(DIRECTION.DOWN);
                        break;
                    case LEFT:
                        entity.setDirection(DIRECTION.LEFT);
                        break;
                    case RIGHT:
                        entity.setDirection(DIRECTION.RIGHT);
                        break;
                }
                entity.lifeCount();
                setDrawable(false);
            }

        }
        if (unit instanceof Player) {
//            if (unit.getGame().getLevel().getEnemy().getX() == x && unit.getGame().getLevel().getEnemy().getY() == y) {
//                unit.getGame().getLevel().getEnemy().setNotShot(false);
//            }
            for (Enemy enemy : unit.getGame().getLevel().getEnemies()) {
                if(enemy.getX() == x && enemy.getY() == y){
                    enemy.setNotShot(false);
                }
            }
        }

    }

    @Override
    public void tick() {
        move();
        isShot(x, y);
    }


    private void move() {
        int move = unit.getGame().move(unit);
        if (drawable) {
            int height = unit.getGame().getDisplay().getHeight();
            int width = unit.getGame().getDisplay().getWidth();
            if (y > -10 && y < height) {
                if (x > -10 && x < width) {
                    switch (getDirection()) {
                        case UP:
                            y -= move;
                            break;
                        case DOWN:
                            y += move;
                            break;
                        case RIGHT:
                            x += move;
                            break;
                        case LEFT:
                            x -= move;
                            break;
                    }
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        // center of model
        int iDontNowWhy = 3;
        if (drawable) {
            switch (direction) {
                case UP:
                    g.drawImage(Assets.getBulletUp(), x + iDontNowWhy, y, width, height, null);
                    break;
                case DOWN:
                    g.drawImage(Assets.getBulletDown(), x + iDontNowWhy, y, width, height, null);
                    break;
                case RIGHT:
                    g.drawImage(Assets.getBulletRight(), x, y + iDontNowWhy, width, height, null);
                    break;
                case LEFT:
                    g.drawImage(Assets.getBulletLeft(), x, y + iDontNowWhy, width, height, null);
                    break;
            }
        } else {
            setDrawable(false);
            setNotShot(false);
            unit.getBullets().remove(this);
        }
    }
}
