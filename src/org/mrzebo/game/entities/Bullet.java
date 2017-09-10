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
    private Image upModel;
    private Image downModel;
    private Image leftModel;
    private Image rightModel;

    public Bullet(AbstractUnit unit, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.unit = unit;
        setDirection(unit.getDirection());
        upModel = Assets.getBulletUp();
        downModel = Assets.getBulletDown();
        leftModel = Assets.getBulletLeft();
        rightModel = Assets.getBulletRight();

    }

    boolean isDrawable() {
        return drawable;
    }

    private void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public void isShot(int x, int y) {
        for (Entity entity : unit.getGame().getLevel().getEntities()) {
            if (entity.getX() == x && entity.getY() == y
                    || (entity.getX() - 5 == x && entity.getY() - 5 == y
                    || entity.getX() + 5 == x && entity.getY() + 5 == y)
                    || x - entity.getX() <= 5 && x - entity.getX() >= 0 && y == entity.getY()
                    || entity.getX() - x <= 5 && entity.getX() - x >= 0 && y == entity.getY()
                    || x == entity.getX() && y - entity.getY() <= 5 && y - entity.getY() >= 0
                    || x == entity.getX() && entity.getY() - y <= 5 && entity.getY() - y >= 0) {
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
            for (Enemy enemy : unit.getGame().getLevel().getEnemies()) {
                if (enemy == null) return;
                if (x == enemy.getX() && y == enemy.getY()) {
                    enemy.setNotShot(false);
                    setDrawable(false);
                }
                if (x - enemy.getX() <= 5 && x - enemy.getX() >= 0 && y == enemy.getY()) {
                    enemy.setNotShot(false);
                    setDrawable(false);
                }
                if (enemy.getX() - x <= 5 && enemy.getX() - x >= 0 && y == enemy.getY()) {
                    enemy.setNotShot(false);
                    setDrawable(false);
                }
                if (x == enemy.getX() && y - enemy.getY() <= 5 && y - enemy.getY() >= 0) {
                    enemy.setNotShot(false);
                    setDrawable(false);
                }
                if (x == enemy.getX() && enemy.getY() - y <= 5 && enemy.getY() - y >= 0) {
                    enemy.setNotShot(false);
                    setDrawable(false);
                }
            }
            if (unit.getGame().getLevel().getEagle().getX() == x && unit.getGame().getLevel().getEagle().getY() == y) {
                System.out.println("eagle die");
                unit.getGame().getLevel().getEagle().lifeCount();
            }
        }

        if (unit instanceof Enemy) {
            if (unit.getGame().getLevel().getEagle().getX() == x && unit.getGame().getLevel().getEagle().getY() == y) {
                System.out.println("eagle die");
                unit.getGame().getLevel().getEagle().lifeCount();
            }
            if (x == unit.getGame().getPlayer().getX() && y == unit.getGame().getPlayer().getY()) {
                System.out.println("Player died");
                unit.getGame().getPlayer().lifeCount();
            }
            if (x - unit.getGame().getLevel().getEagle().getX() <= 5 && x - unit.getGame().getLevel().getEagle().getX() >= 0 && y == unit.getGame().getLevel().getEagle().getY()) {
                System.out.println("Eagle died");
                unit.getGame().getLevel().getEagle().lifeCount();
            }
            if (unit.getGame().getLevel().getEagle().getX() - x <= 5 && unit.getGame().getLevel().getEagle().getX() - x >= 0 && y == unit.getGame().getLevel().getEagle().getY()) {
                System.out.println("Eagle died");
                unit.getGame().getLevel().getEagle().lifeCount();
            }
            if (x == unit.getGame().getLevel().getEagle().getX() && y - unit.getGame().getLevel().getEagle().getY() <= 5 && y - unit.getGame().getLevel().getEagle().getY() >= 0) {
                System.out.println("Eagle died");
                unit.getGame().getLevel().getEagle().lifeCount();
            }
            if (x == unit.getGame().getLevel().getEagle().getX() && unit.getGame().getLevel().getEagle().getY() - y <= 5 && unit.getGame().getLevel().getEagle().getY() - y >= 0) {
                System.out.println("Eagle died");
                unit.getGame().getLevel().getEagle().lifeCount();
            }


            if (x == unit.getGame().getPlayer().getX() && y == unit.getGame().getPlayer().getY()) {
                System.out.println("Player died");
                unit.getGame().getPlayer().lifeCount();
            }
            if (x - unit.getGame().getPlayer().getX() <= 5 && x - unit.getGame().getPlayer().getX() >= 0 && y == unit.getGame().getPlayer().getY()) {
                System.out.println("Player died");
                unit.getGame().getPlayer().lifeCount();
            }
            if (unit.getGame().getPlayer().getX() - x <= 5 && unit.getGame().getPlayer().getX() - x >= 0 && y == unit.getGame().getPlayer().getY()) {
                System.out.println("Player died");
                unit.getGame().getPlayer().lifeCount();
            }
            if (x == unit.getGame().getPlayer().getX() && y - unit.getGame().getPlayer().getY() <= 5 && y - unit.getGame().getPlayer().getY() >= 0) {
                System.out.println("Player died");
                unit.getGame().getPlayer().lifeCount();
            }
            if (x == unit.getGame().getPlayer().getX() && unit.getGame().getPlayer().getY() - y <= 5 && unit.getGame().getPlayer().getY() - y >= 0) {
                System.out.println("Player died");
                unit.getGame().getPlayer().lifeCount();
            }

            for (Enemy enemy : unit.getGame().getLevel().getEnemies()) {
                if (unit != enemy) {
                    if (x == enemy.getX() && y == enemy.getY()) {
                        if (enemy.life == 0) {
                            enemy.setNotShot(false);
                            setDrawable(false);
                        } else {
                            enemy.lifeCount();
                        }
                    }
                    if (x - enemy.getX() <= 5 && x - enemy.getX() >= 0 && y == enemy.getY()) {
                        if (enemy.life == 0) {
                            enemy.setNotShot(false);
                            setDrawable(false);
                        } else {
                            enemy.lifeCount();
                        }
                    }
                    if (enemy.getX() - x <= 5 && enemy.getX() - x >= 0 && y == enemy.getY()) {
                        if (enemy.life == 0) {
                            enemy.setNotShot(false);
                            setDrawable(false);
                        } else {
                            enemy.lifeCount();
                        }
                    }
                    if (x == enemy.getX() && y - enemy.getY() <= 5 && y - enemy.getY() >= 0) {
                        if (enemy.life == 0) {
                            enemy.setNotShot(false);
                            setDrawable(false);
                        } else {
                            enemy.lifeCount();
                        }
                    }
                    if (x == enemy.getX() && enemy.getY() - y <= 5 && enemy.getY() - y >= 0) {
                        if (enemy.life == 0) {
                            enemy.setNotShot(false);
                            setDrawable(false);
                        } else {
                            enemy.lifeCount();
                        }
                    }
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
//        int move = unit.getGame().move(unit);
        int move = 5;
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
        int iDontKnowWhy = 3;
        if (x > 590) return;
        if (x < 15) return;
        if (y > 575) return;
        if (y < 15) return;
        if (drawable) {
            switch (direction) {
                case UP:
                    g.drawImage(upModel, x + iDontKnowWhy, y, width, height, null);
                    break;
                case DOWN:
                    g.drawImage(downModel, x + iDontKnowWhy, y, width, height, null);
                    break;
                case RIGHT:
                    g.drawImage(rightModel, x, y + iDontKnowWhy, width, height, null);
                    break;
                case LEFT:
                    g.drawImage(leftModel, x, y + iDontKnowWhy, width, height, null);
                    break;
            }
        } else {
            setDrawable(false);
            setNotShot(false);
            unit.getBullets().remove(this);

        }
    }
}
