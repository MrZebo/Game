package org.mrzebo.game.levels;

import org.mrzebo.game.entities.Eagle;
import org.mrzebo.game.entities.Entity;
import org.mrzebo.game.entities.Wall;
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.gfx.Assets;

import java.awt.*;

public class Level1 extends Level {
    private Canvas canvas;


    Level1() {
        enemyCount = 5;
        init();
        eagle = new Eagle(Assets.getEagle(), 300, 585, 15, 15);
        enemies = new Enemy[3];
    }

    @Override
    public void tick() {
        int x = 200;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] == null) {
                enemies[i] = new Enemy(game, this, Assets.getEnemyDown(), x += 100, 0, 15, 15);
            }
        }
        x = 200;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].isNotShot()) {
                enemies[i].tick();
            } else {
                if (getEnemyCount() > 0) {
                    lowerEnemyCount();
                    enemies[i] = new Enemy(game, this, Assets.getEnemyDown(), x += 100, 0, 15, 15);
                }
            }
        }
        x = 200;
    }

    public void init() {
        int x = 0;
        int y = 15;
        canvas = new Canvas();
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 40; j++) {
                getEntities().add(new Wall(Assets.getFullWall(), x, y, 15, 15));
                x += 15;
            }
            x = 0;
            y += 30;
        }
        x = 15;
        y = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 40; j++) {
                getEntities().add(new Wall(Assets.getFullWall(), x, y, 15, 15));
                y += 15;
            }
            x += 30;
            y = 0;
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void render(Graphics g) {
        eagle.render(g);
        for (Enemy enemy : enemies) {
            enemy.render(g);
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
