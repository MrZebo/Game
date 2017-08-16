package org.mrzebo.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static BufferedImage fullWall;
    private static BufferedImage fullWhiteWall;
    private static BufferedImage upHalfWall;
    private static BufferedImage downHalfWall;
    private static BufferedImage rightHalfWall;
    private static BufferedImage leftHalfWall;
    private static BufferedImage playerUp;
    private static BufferedImage playerDown;
    private static BufferedImage playerLeft;
    private static BufferedImage playerRight;
    private static BufferedImage enemyUp;
    private static BufferedImage enemyDown;
    private static BufferedImage enemyLeft;
    private static BufferedImage enemyRight;
    private static BufferedImage eagle;
    private static BufferedImage bulletUp;
    private static BufferedImage bulletDown;
    private static BufferedImage bulletLeft;
    private static BufferedImage bulletRight;
    private static BufferedImage empty;
    private static BufferedImage emptyBullet;
    private static BufferedImage wood;
    private static BufferedImage[] explosive = new BufferedImage[3];


    public static BufferedImage getBulletUp() {
        return bulletUp;
    }

    public static BufferedImage getBulletDown() {
        return bulletDown;
    }

    public static BufferedImage getBulletLeft() {
        return bulletLeft;
    }

    public static BufferedImage getBulletRight() {
        return bulletRight;
    }

    public static BufferedImage[] getExplosive() {
        return explosive;
    }

    public static BufferedImage getEmpty() {
        return empty;
    }

    public static BufferedImage getEmptyBullet() {
        return emptyBullet;
    }

    public static BufferedImage getFullWhiteWall() {
        return fullWhiteWall;
    }

    public static BufferedImage getEnemyDown() {
        return enemyDown;
    }

    public static BufferedImage getEnemyLeft() {
        return enemyLeft;
    }

    public static BufferedImage getEnemyRight() {
        return enemyRight;
    }

    public static void init() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/test.png"));
        wood = spriteSheet.getImage(272, 32, 15, 15);
        fullWhiteWall = spriteSheet.getImage(256, 16, 15, 15);
        explosive[0] = spriteSheet.getImage(255, 130, 14, 14);
        explosive[1] = spriteSheet.getImage(270, 130, 16, 14);
        explosive[2] = spriteSheet.getImage(287, 130, 16, 16);
        empty = spriteSheet.getImage(260, 200, 15, 15);
        emptyBullet = spriteSheet.getImage(260, 200, 10, 10);
        bulletUp = spriteSheet.getImage(320, 100, 10, 10);
        bulletDown = spriteSheet.getImage(336, 100, 10, 10);
        bulletLeft = spriteSheet.getImage(328, 100, 10, 10);
        bulletRight = spriteSheet.getImage(342, 100, 10, 10);
        playerUp = spriteSheet.getImage(0, 0, 15, 15);
        playerDown = spriteSheet.getImage(63, 0, 15, 15);
        playerLeft = spriteSheet.getImage(35, 0, 15, 15);
        playerRight = spriteSheet.getImage(95, 0, 15, 15);
        fullWall = spriteSheet.getImage(256, 0, 15, 15);
        upHalfWall = spriteSheet.getImage(256, 0, 15, 7);
        downHalfWall = spriteSheet.getImage(256, 0, 15, 7);
        rightHalfWall = spriteSheet.getImage(273, 0, 15, 15);
        leftHalfWall = spriteSheet.getImage(256, 0, 7, 15);
        enemyUp = spriteSheet.getImage(127, 0, 15, 15);
        enemyDown = spriteSheet.getImage(191, 0, 15, 15);
        enemyLeft = spriteSheet.getImage(160, 0, 15, 15);
        enemyRight = spriteSheet.getImage(223, 0, 15, 15);
        eagle = spriteSheet.getImage(304, 32, 15, 15);
    }

    public static BufferedImage getPlayerDown() {
        return playerDown;
    }

    public static BufferedImage getPlayerLeft() {
        return playerLeft;
    }

    public static BufferedImage getPlayerRight() {
        return playerRight;
    }

    public static BufferedImage getEagle() {
        return eagle;
    }

    public static BufferedImage getEnemyUp() {
        return enemyUp;
    }

    public static BufferedImage getFullWall() {
        return fullWall;
    }

    public static BufferedImage getPlayerUp() {
        return playerUp;
    }

    public static BufferedImage getUpHalfWall() {
        return upHalfWall;
    }

    public static BufferedImage getDownHalfWall() {
        return downHalfWall;
    }

    public static BufferedImage getRightHalfWall() {
        return rightHalfWall;
    }

    public static BufferedImage getLeftHalfWall() {
        return leftHalfWall;
    }

    public static BufferedImage getWood() {
        return wood;
    }
}
