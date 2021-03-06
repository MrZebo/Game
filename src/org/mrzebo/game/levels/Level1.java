package org.mrzebo.game.levels;

import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Buff;
import org.mrzebo.game.entities.Eagle;
import org.mrzebo.game.entities.Entity;
import org.mrzebo.game.entities.Wall;
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.entities.units.Player;
import org.mrzebo.game.gfx.Assets;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class Level1 extends Level {
    private Canvas canvas;
    private long timeStart;


    Level1(Game game, Player player) {
        super(game, player);
        enemyCount = 300;
        buffCount = 5;
        init();
        timeStart = System.nanoTime();
        eagle = new Eagle(300, 570, 15, 15);
        enemies = new CopyOnWriteArrayList<>();
        int x = 75;
        if (enemies.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                enemies.add(new Enemy(game, this, x += 100, 15, 15, 15));
            }
        }
    }

    @Override
    public void tick() {
        int x = (int) (Math.random() * 5);
        int[] randomPoint = {75, 150, 225, 300, 375, 450};
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                if (enemy.isNotShot()) {
                    enemy.tick();
                } else {
                    if (getEnemyCount() > 0) {
                        lowerEnemyCount();
                        enemies.remove(enemy);
                        enemies.add(new Enemy(game, this, randomPoint[x], 15, 15, 15));
                    } else {
                        for (Enemy enemy1 : enemies) {
                            if (enemy1.isNotShot()) {
                                enemy1.tick();
                            } else {
                                enemies.remove(enemy1);
                            }
                        }
                        if (enemies.isEmpty()) {
                            Game.lvlUp();
                        }
                    }

                }
            }
        }
        buffObserver();
        if (buff != null) {
            buff.tick();
        }
    }

    public void init() {
        canvas = new Canvas();
        int x = 15;
        int y = 15;
        canvas = new Canvas();
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 39; j++) {
                getEntities().add(new Wall(x, y, 15, 15));
                x += 15;
            }
            x = 15;
            y += 30;
        }
        x = 15;
        y = 15;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 38; j++) {
                getEntities().add(new Wall(x, y, 15, 15));
                y += 15;
            }
            x += 30;
            y = 15;
        }
    }

    @Override
    void buffObserver() {
        long time = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - timeStart);

        int x = (int) (Math.random() * 37);
        int y = (int) (Math.random() * 37);
        int a = 30;
        int[] steps = new int[37];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = a;
            a += 15;
        }
        if (time % 15 == 0) buff = null;
        if (canDraw(steps[x], steps[y])) {
            if (time % 5 == 0 && time != 0 && buff == null && buffCount > 0) {
                buff = new Buff(this, steps[x], steps[y], 15, 15);
                buffCount--;
            }
        } else {
            while (!canDraw(steps[x], steps[y])) {
                x = (int) (Math.random() * 37);
                y = (int) (Math.random() * 37);
            }

        }

//        if (time % 15 == 0) buff = null;
//        if (time % 15 == 0) buff1 = null;
//        if (time % 5 == 0 && time != 0 && buff == null) {
//            buff = new Buff(this, 240, 30, 15, 15);
//        }
//        if (time % 5 == 0 && time != 0 && buff1 == null) {
//            buff1 = new Buff(this, 260, 15, 15, 15);
//        }
    }

    private boolean canDraw(int x, int y) {
        for (Entity entity : getEntities()) {
            if (x == entity.getX() && y == entity.getY()) return false;
        }
        return true;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void render(Graphics g) {
        int x = 615;
        int y = 25;
        eagle.render(g);
        if (buff != null) {
            buff.render(g);
        }
        for (int i = 1; i <= enemyCount; i++) {
            g.drawImage(Assets.getEnemyPicture(), x, y, null);
            x += 15;
            if (i % 5 == 0) {
                x = 615;
                y += 25;
            }
        }
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                if (enemy.isNotShot()) {
                    enemy.render(g);
                }
            }
        }
        for (Entity entity : getEntities()) {
            if (entity.isNotShot()) {
                entity.render(g);
            } else {
                getEntities().remove(entity);
            }
        }
    }

}
