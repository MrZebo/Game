package org.mrzebo.game.entities;

import org.mrzebo.game.DIRECTION;

import java.awt.*;

public abstract class Entity {

    protected int x, y;
    protected int width, height;
    protected boolean isNotShot;
    protected DIRECTION direction;
    protected int life = 2;

    public Entity( int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isNotShot = true;
    }
//    public Entity(Image image, int x, int y, int width, int height) {
//        this.image = image;
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        isNotShot = true;
//    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public int getLife() {
        return life;
    }

    public void lifeCount() {
        life -= 1;
    }

    public boolean isNotShot() {
        return isNotShot;
    }

    public void setNotShot(boolean notShot) {
        isNotShot = notShot;
    }

//    public void setImage(Image image) {
//        this.image = image;
//    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

//    public Image getImage() {
//        return image;
//    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
