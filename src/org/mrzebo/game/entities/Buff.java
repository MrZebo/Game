package org.mrzebo.game.entities;

import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.gfx.Assets;
import org.mrzebo.game.levels.Level;

import java.awt.*;

public class Buff extends Entity {
    private boolean blink;
    private Level level;
    private Image image;

    public Buff(Level level, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.level = level;
        image = Assets.getBuffStar();
        blink = true;
    }

    @Override
    public void tick() {
        if (blink) {
            blink = false;
        } else {
            blink = true;
        }
        for (Enemy enemy : level.getEnemies()) {
            if (enemy.getX() == x && enemy.getY() == y) {
                enemy.levelObserver(true);
                level.setBuff(null);
                break;
            }

        }
        if(level.getPlayer().getX() == x && level.getPlayer().getY() == y){
            System.out.println("Player lvl up!");
        }


    }

    @Override
    public void render(Graphics g) {
        if (blink) {
            g.drawImage(image, x, y, null);
        }
    }
}
