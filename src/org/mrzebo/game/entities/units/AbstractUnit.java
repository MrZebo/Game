package org.mrzebo.game.entities.units;

import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Bullet;
import org.mrzebo.game.entities.Entity;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;


public abstract class AbstractUnit extends Entity {

    protected CopyOnWriteArrayList<Bullet> bullets;
    protected int xMove, yMove;
    protected Game game;
    protected boolean modelRender = true;
    int unitLevel = 1;
    int speed = 1;
    Image upFirst;
    Image upSecond;
    Image downFirst;
    Image downSecond;
    Image leftFirst;
    Image leftSecond;
    Image rightFirst;
    Image rightSecond;

    public int getSpeed() {
        return speed;
    }

    public void setBullets(CopyOnWriteArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public AbstractUnit(Game game, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.game = game;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        x += xMove;
        y += yMove;
        xMove = 0;
        yMove = 0;
    }

    public abstract void levelObserver(boolean change);

    public void modelRender() {
        if (modelRender) {
            modelRender = false;
        } else {
            modelRender = true;
        }
    }

    public Game getGame() {
        return game;
    }

    public CopyOnWriteArrayList<Bullet> getBullets() {
        return bullets;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }



}
