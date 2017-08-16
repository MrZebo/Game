package org.mrzebo.game.entities.units;


import org.mrzebo.game.DIRECTION;
import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Bullet;
import org.mrzebo.game.gfx.Assets;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Player extends AbstractUnit {
    private Game game;


    public CopyOnWriteArrayList<Bullet> getBullets() {
        return bullets;
    }


    public Player(Game game, Image image, int x, int y) {
        super(game, image, x, y, AbstractUnit.DEFAULT_CREATURE_WIDTH, AbstractUnit.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
        bullets = new CopyOnWriteArrayList<>();
        direction = DIRECTION.UP;
    }

    @Override
    public void tick() {
        move();
        if (!bullets.isEmpty()) {
            for (Bullet bullet : bullets) {
                bullet.tick();
            }
        }
    }


    public Game getGame() {
        return game;
    }

    @Override
    public void render(Graphics g) {
        switch (direction) {
            case UP:
                g.drawImage(Assets.getPlayerUp(), x, y, width, height, null);
                break;
            case DOWN:
                g.drawImage(Assets.getPlayerDown(), x, y, width, height, null);
                break;
            case RIGHT:
                g.drawImage(Assets.getPlayerRight(), x, y, width, height, null);
                break;
            case LEFT:
                g.drawImage(Assets.getPlayerLeft(), x, y, width, height, null);
                break;
        }
        if (!bullets.isEmpty()) {
            for (Bullet bullet : bullets) {
                bullet.render(g);
            }
        }
    }

}
