package org.mrzebo.game.entities.units;

import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Bullet;
import org.mrzebo.game.entities.Entity;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;


public abstract class AbstractUnit extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 15,
            DEFAULT_CREATURE_HEIGHT = 15;
    protected CopyOnWriteArrayList<Bullet> bullets;
    protected int health;
    protected float speed;
    protected int xMove, yMove;
    protected Game game;

    public AbstractUnit(Game game, Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
        this.game = game;
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        x += xMove;
        y += yMove;
        xMove = 0;
        yMove = 0;
    }

    //GETTERS SETTERS

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
