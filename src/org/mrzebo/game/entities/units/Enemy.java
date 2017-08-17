package org.mrzebo.game.entities.units;

import org.mrzebo.game.DIRECTION;
import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Bullet;
import org.mrzebo.game.gfx.Assets;
import org.mrzebo.game.levels.Level;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by MrZebo on 14.08.2017.
 */
public class Enemy extends AbstractUnit {
    private Level level;
    private Player player;

    public Enemy(Game game, Level level, Image image, int x, int y, int width, int height) {
        super(game, image, x, y, width, height);
        direction = DIRECTION.DOWN;
        this.level = level;
        player = this.level.getGame().getPlayer();
        bullets = new CopyOnWriteArrayList<>();
    }

    @Override
    public void tick() {
        int a = level.getGame().move(this);
        if (isNotShot) {
            if (level.movable(this, direction)) {
                switch (direction) {
                    case LEFT:
                        setDirection(DIRECTION.LEFT);
                        setxMove(-a);
                        if (player.getX() < getX() && player.getY() == getY()) {
                            bullets.add(new Bullet(this, Assets.getBulletLeft(), x, y, 10, 10));
                        }
                        break;
                    case RIGHT:
                        setDirection(DIRECTION.RIGHT);
                        setxMove(a);
                        if (player.getX() > getX() && player.getY() == getY()) {
                            bullets.add(new Bullet(this, Assets.getBulletRight(), x, y, 10, 10));
                        }
                        break;
                    case UP:
                        setDirection(DIRECTION.UP);
                        setyMove(-a);
                        if (player.getX() == getX() && player.getY() < getY()) {
                            bullets.add(new Bullet(this, Assets.getBulletUp(), x, y, 10, 10));
                        }
                        break;
                    case DOWN:
                        setDirection(DIRECTION.DOWN);
                        setyMove(a);
                        if (player.getX() == getX() && player.getY() > getY()) {
                            bullets.add(new Bullet(this, Assets.getBulletDown(), x, y, 10, 10));
                        }
                        break;
                }
            } else {
                int b = (int) (Math.random() * 4);
                setDirection(DIRECTION.values()[b]);
                Image assets = null;
                switch (b) {
                    case 0:
                        assets = Assets.getBulletUp();
                        break;
                    case 1:
                        assets = Assets.getBulletDown();
                        break;
                    case 2:
                        assets = Assets.getBulletRight();
                        break;
                    case 3:
                        assets = Assets.getBulletLeft();
                        break;

                }
                bullets.add(new Bullet(this, assets, x, y, 10, 10));
            }
            move();
            if (!bullets.isEmpty()) {
                for (Bullet bullet : bullets) {
                    bullet.tick();
                }
            }
        }

    }

    @Override
    public void render(Graphics g) {
        if (isNotShot) {
            switch (direction) {
                case UP:
                    g.drawImage(Assets.getEnemyUp(), x, y, null);
                    break;
                case DOWN:
                    g.drawImage(Assets.getEnemyDown(), x, y, null);
                    break;
                case LEFT:
                    g.drawImage(Assets.getEnemyLeft(), x, y, null);
                    break;
                case RIGHT:
                    g.drawImage(Assets.getEnemyRight(), x, y, null);
                    break;
            }
        }
        if (!bullets.isEmpty()) {
            for (Bullet bullet : bullets) {
                bullet.render(g);
            }
        }
    }
}
