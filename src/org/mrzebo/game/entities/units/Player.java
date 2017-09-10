package org.mrzebo.game.entities.units;


import org.mrzebo.game.DIRECTION;
import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Bullet;
import org.mrzebo.game.gfx.Assets;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Player extends AbstractUnit {
    private Game game;

    int score;


    public CopyOnWriteArrayList<Bullet> getBullets() {
        return bullets;
    }


    public Player(Game game, int x, int y) {
        super(game, x, y, 15, 15);
        this.game = game;
        bullets = new CopyOnWriteArrayList<>();
        direction = DIRECTION.UP;
        life = 1;
        upFirst = Assets.getPlayerUpFirst();
        upSecond = Assets.getPlayerUpSecond();
        downFirst = Assets.getPlayerDownFirst();
        downSecond = Assets.getPlayerDownSecond();
        leftFirst = Assets.getPlayerLeftFirst();
        leftSecond = Assets.getPlayerLeftSecond();
        rightFirst = Assets.getPlayerRightFirst();
        rightSecond = Assets.getPlayerRightSecond();
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


    @Override
    public void levelObserver(boolean change) {

    }

    public Game getGame() {
        return game;
    }

    @Override
    public void render(Graphics g) {
        switch (direction) {
            case UP:
                if (modelRender) {
                    g.drawImage(Assets.getPlayerUpFirst(), x, y, width, height, null);
                } else {
                    g.drawImage(Assets.getPlayerUpSecond(), x, y, width, height, null);
                }
                break;
            case DOWN:
                if (modelRender) {
                    g.drawImage(Assets.getPlayerDownFirst(), x, y, width, height, null);
                } else {
                    g.drawImage(Assets.getPlayerDownSecond(), x, y, width, height, null);
                }
                break;
            case RIGHT:
                if (modelRender) {
                    g.drawImage(Assets.getPlayerRightFirst(), x, y, width, height, null);
                } else {
                    g.drawImage(Assets.getPlayerRightSecond(), x, y, width, height, null);
                }
                break;
            case LEFT:
                if (modelRender) {
                    g.drawImage(Assets.getPlayerLeftFirst(), x, y, width, height, null);
                } else {
                    g.drawImage(Assets.getPlayerLeftSecond(), x, y, width, height, null);
                }
                break;
        }
        if (!bullets.isEmpty()) {
            for (Bullet bullet : bullets) {
                bullet.render(g);
            }
        }

    }

}
