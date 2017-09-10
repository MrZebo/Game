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


    public Enemy(Game game, Level level, int x, int y, int width, int height) {
        super(game, x, y, width, height);
        direction = DIRECTION.DOWN;
        life = 1;
        this.level = level;
        player = level.getPlayer();
        bullets = new CopyOnWriteArrayList<>();
        upFirst = Assets.getEnemy1UpFirst();
        upSecond = Assets.getEnemy1UpSecond();
        downFirst = Assets.getEnemy1DownFirst();
        downSecond = Assets.getEnemy1DownSecond();
        leftFirst = Assets.getEnemy1LeftFirst();
        leftSecond = Assets.getEnemy1LeftSecond();
        rightFirst = Assets.getEnemy1RightFirst();
        rightSecond = Assets.getEnemy1RightSecond();
    }

    private boolean frequency() {
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while (true) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            return delta >= 1;
        }
    }

    @Override
    public void tick() {
        int step = this.getSpeed();
        if (isNotShot) {
            if (level.movable(this, direction)) {
                switch (direction) {
                    case LEFT:
                        setDirection(DIRECTION.LEFT);
                        setxMove(-step);
                        if (player.getX() < getX() && player.getY() == getY() && frequency()) {
                            bullets.add(new Bullet(this, x, y, 10, 10));
                        }
                        if (level.getEagle().getX() < getX() && level.getEagle().getY() == getY() && frequency()) {
                            bullets.add(new Bullet(this, x, y, 10, 10));
                        }
                        modelRender();
                        break;
                    case RIGHT:
                        setDirection(DIRECTION.RIGHT);
                        setxMove(step);
                        if (player.getX() > getX() && player.getY() == getY() && frequency()) {
                            bullets.add(new Bullet(this, x, y, 10, 10));

                        }
                        if (level.getEagle().getX() > getX() && level.getEagle().getY() == getY() && frequency()) {
                            bullets.add(new Bullet(this, x, y, 10, 10));
                        }
                        modelRender();
                        break;
                    case UP:
                        setDirection(DIRECTION.UP);
                        setyMove(-step);
                        if (player.getX() == getX() && player.getY() < getY() && frequency()) {
                            bullets.add(new Bullet(this, x, y, 10, 10));

                        }
                        if (level.getEagle().getX() == getX() && level.getEagle().getY() < getY() && frequency()) {
                            bullets.add(new Bullet(this, x, y, 10, 10));
                        }
                        modelRender();
                        break;
                    case DOWN:
                        setDirection(DIRECTION.DOWN);
                        setyMove(step);
                        if (player.getX() == getX() && player.getY() > getY() && frequency()) {
                            bullets.add(new Bullet(this, x, y, 10, 10));

                        }
                        if (level.getEagle().getX() == getX() && level.getEagle().getY() > getY() && frequency()) {
                            bullets.add(new Bullet(this, x, y, 10, 10));
                        }
                        modelRender();
                        break;
                }
            } else {
                int b = (int) (Math.random() * 4);
                setDirection(DIRECTION.values()[b]);
                bullets.add(new Bullet(this, x, y, 10, 10));
                if (unitLevel == 3) {
                    setDirection(DIRECTION.values()[b]);
                    bullets.add(new Bullet(this, x, y, 10, 10));
                }
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
                    if (modelRender) {
                        g.drawImage(upFirst, x, y, null);
                    } else {
                        g.drawImage(upSecond, x, y, null);
                    }
                    break;
                case DOWN:
                    if (modelRender) {
                        g.drawImage(downFirst, x, y, null);
                    } else {
                        g.drawImage(downSecond, x, y, null);
                    }
                    break;
                case LEFT:
                    if (modelRender) {
                        g.drawImage(leftFirst, x, y, null);
                    } else {
                        g.drawImage(leftSecond, x, y, null);
                    }
                    break;
                case RIGHT:
                    if (modelRender) {
                        g.drawImage(rightFirst, x, y, null);
                    } else {
                        g.drawImage(rightSecond, x, y, null);
                    }
                    break;
            }
        }
        if (!isNotShot) {
            bullets.clear();
        }
        if (!bullets.isEmpty()) {
            for (Bullet bullet : bullets) {
                bullet.render(g);
            }
        }
    }

    @Override
    public void levelObserver(boolean change) {
        if (change) {
            unitLevel++;
        } else {
            unitLevel--;
        }
        switch (unitLevel) {
            case 1:
                upFirst = Assets.getEnemy1UpFirst();
                upSecond = Assets.getEnemy1UpSecond();
                downFirst = Assets.getEnemy1DownFirst();
                downSecond = Assets.getEnemy1DownSecond();
                leftFirst = Assets.getEnemy1LeftFirst();
                leftSecond = Assets.getEnemy1LeftSecond();
                rightFirst = Assets.getEnemy1RightFirst();
                rightSecond = Assets.getEnemy1RightSecond();

                break;
            case 2:
//                speed = 2;
                life = 2;
                upFirst = Assets.getEnemy2UpFirst();
                upSecond = Assets.getEnemy2UpSecond();
                downFirst = Assets.getEnemy2DownFirst();
                downSecond = Assets.getEnemy2DownSecond();
                leftFirst = Assets.getEnemy2LeftFirst();
                leftSecond = Assets.getEnemy2LeftSecond();
                rightFirst = Assets.getEnemy2RightFirst();
                rightSecond = Assets.getEnemy2RightSecond();
                break;
            case 3:
//                speed = 1;
                upFirst = Assets.getEnemy3UpFirst();
                upSecond = Assets.getEnemy3UpSecond();
                downFirst = Assets.getEnemy3DownFirst();
                downSecond = Assets.getEnemy3DownSecond();
                leftFirst = Assets.getEnemy3LeftFirst();
                leftSecond = Assets.getEnemy3LeftSecond();
                rightFirst = Assets.getEnemy3RightFirst();
                rightSecond = Assets.getEnemy3RightSecond();
                break;
            case 4:
                life = 2;
//                speed = 3;
                upFirst = Assets.getEnemy4UpFirst();
                upSecond = Assets.getEnemy4UpSecond();
                downFirst = Assets.getEnemy4DownFirst();
                downSecond = Assets.getEnemy4DownSecond();
                leftFirst = Assets.getEnemy4LeftFirst();
                leftSecond = Assets.getEnemy4LeftSecond();
                rightFirst = Assets.getEnemy4RightFirst();
                rightSecond = Assets.getEnemy4RightSecond();
                break;
        }
    }
}
