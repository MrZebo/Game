package org.mrzebo.game.levels;

import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Eagle;
import org.mrzebo.game.entities.Entity;
import org.mrzebo.game.entities.Wall;
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.entities.units.Player;
import org.mrzebo.game.gfx.Assets;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Level1 extends Level {
    private Canvas canvas;


    Level1(Game game, Player player) {
        super(game, player);
        enemyCount = 15;
        init();
        eagle = new Eagle(Assets.getEagle(), 300, 570, 15, 15);
        enemies = new CopyOnWriteArrayList<>();
        int x = 75;
        if (enemies.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                enemies.add(new Enemy(game, this, Assets.getEnemyDown(), x += 100, 15, 15, 15));
            }
        }
    }

    @Override
    public void tick() {
        int x = 75;
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                if (enemy.isNotShot()) {
                    enemy.tick();
                } else {
                    if (getEnemyCount()  > 0) {
                        lowerEnemyCount();
                        enemies.remove(enemy);
                        enemies.add(new Enemy(game, this, Assets.getEnemyDown(), x += 100, 15, 15, 15));
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
    }

    public void init() {
        int x = 15;
        int y = 15;
        canvas = new Canvas();
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 39; j++) {
                getEntities().add(new Wall(Assets.getFullWall(), x, y, 15, 15));
                x += 15;
            }
            x = 15;
            y += 30;
        }
        x = 15;
        y = 15;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 38; j++) {
                getEntities().add(new Wall(Assets.getFullWall(), x, y, 15, 15));
                y += 15;
            }
            x += 30;
            y = 15;
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void render(Graphics g) {
        int x = 615;
        int y = 25;
        eagle.render(g);
        for (int i = 1; i <= enemyCount; i++) {
            g.drawImage(Assets.getEnemy(), x, y, null);
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
