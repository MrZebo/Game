package org.mrzebo.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static BufferedImage fullWall;
    private static BufferedImage fullWhiteWall;
    private static BufferedImage upHalfWall;
    private static BufferedImage downHalfWall;
    private static BufferedImage rightHalfWall;
    private static BufferedImage leftHalfWall;
    private static BufferedImage playerUpFirst;
    private static BufferedImage playerUpSecond;
    private static BufferedImage playerDownFirst;
    private static BufferedImage playerDownSecond;
    private static BufferedImage playerLeftFirst;
    private static BufferedImage playerLeftSecond;
    private static BufferedImage playerRightFirst;
    private static BufferedImage playerRightSecond;
    private static BufferedImage enemyPicture;
    private static BufferedImage enemy4UpFirst;
    private static BufferedImage enemy4UpSecond;
    private static BufferedImage enemy4DownFirst;
    private static BufferedImage enemy4DownSecond;
    private static BufferedImage enemy4LeftFirst;
    private static BufferedImage enemy4LeftSecond;
    private static BufferedImage enemy4RightFirst;
    private static BufferedImage enemy4RightSecond;
    private static BufferedImage enemy3UpFirst;
    private static BufferedImage enemy3UpSecond;
    private static BufferedImage enemy3DownFirst;
    private static BufferedImage enemy3DownSecond;
    private static BufferedImage enemy3LeftFirst;
    private static BufferedImage enemy3LeftSecond;
    private static BufferedImage enemy3RightFirst;
    private static BufferedImage enemy3RightSecond;
    private static BufferedImage enemy2UpFirst;
    private static BufferedImage enemy2UpSecond;
    private static BufferedImage enemy2DownFirst;
    private static BufferedImage enemy2DownSecond;
    private static BufferedImage enemy2LeftFirst;
    private static BufferedImage enemy2LeftSecond;
    private static BufferedImage enemy2RightFirst;
    private static BufferedImage enemy2RightSecond;
    private static BufferedImage enemy1UpFirst;
    private static BufferedImage enemy1UpSecond;
    private static BufferedImage enemy1DownFirst;
    private static BufferedImage enemy1DownSecond;
    private static BufferedImage enemy1LeftFirst;
    private static BufferedImage enemy1LeftSecond;
    private static BufferedImage enemy1RightFirst;
    private static BufferedImage enemy1RightSecond;
    private static BufferedImage eagle;
    private static BufferedImage bulletUp;
    private static BufferedImage bulletDown;
    private static BufferedImage bulletLeft;
    private static BufferedImage bulletRight;
    private static BufferedImage empty;
    private static BufferedImage emptyBullet;
    private static BufferedImage wood;
    private static BufferedImage gameOver;
    private static BufferedImage[] explosive = new BufferedImage[3];
    private static BufferedImage buffStar;
    private static BufferedImage buffClock;
    private static BufferedImage buffHelmet;
<<<<<<< HEAD
    private static BufferedImage cursorYellow;
    private static BufferedImage cursorGreen;
    private static BufferedImage cursorRed;
    private static BufferedImage cursorSilver;
=======
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281

    public static BufferedImage getCursorYellow() {
        return cursorYellow;
    }

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

    public static BufferedImage getEnemy1DownFirst() {
        return enemy1DownFirst;
    }

    public static BufferedImage getEnemy1LeftFirst() {
        return enemy1LeftFirst;
    }

    public static BufferedImage getEnemy1RightFirst() {
        return enemy1RightFirst;
    }

    public static BufferedImage getGameOver() {
        return gameOver;
    }

    public static BufferedImage getEnemyPicture() {
        return enemyPicture;
    }

    public static BufferedImage getBuffStar() {
        return buffStar;
    }

    public static BufferedImage getBuffClock() {
        return buffClock;
    }

    public static BufferedImage getBuffHelmet() {
        return buffHelmet;
    }

    public static BufferedImage getPlayerUpSecond() {
        return playerUpSecond;
    }

    public static BufferedImage getPlayerDownSecond() {
        return playerDownSecond;
    }

    public static BufferedImage getPlayerLeftSecond() {
        return playerLeftSecond;
    }

    public static BufferedImage getPlayerRightSecond() {
        return playerRightSecond;
    }

    public static BufferedImage getCursorGreen() {
        return cursorGreen;
    }

    public static BufferedImage getCursorRed() {
        return cursorRed;
    }

    public static BufferedImage getCursorSilver() {
        return cursorSilver;
    }

    public static BufferedImage getBuffStar() {
        return buffStar;
    }

    public static BufferedImage getBuffClock() {
        return buffClock;
    }

    public static BufferedImage getBuffHelmet() {
        return buffHelmet;
    }

    public static void init() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/test1.png"));
        buffStar = spriteSheet.getImage(304, 112, 15, 15);
        buffClock = spriteSheet.getImage(272, 112, 15, 15);
        buffHelmet = spriteSheet.getImage(256, 112, 15, 15);
<<<<<<< HEAD
        enemyPicture = spriteSheet.getImage(320, 192, 9, 8);
        spriteSheet = new SpriteSheet(ImageLoader.loadImage("/cursor.png"));
        cursorYellow = spriteSheet.getImage(95, 0, 25, 25);
        cursorSilver = spriteSheet.getImage(224, 0, 25, 25);
        cursorGreen = spriteSheet.getImage(96, 118, 25, 25);
        cursorRed= spriteSheet.getImage(224, 119, 25, 25);
=======
        enemy = spriteSheet.getImage(320, 192, 9, 8);
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281
        spriteSheet = new SpriteSheet(ImageLoader.loadImage("/test.png"));
        wood = spriteSheet.getImage(272, 32, 15, 15);
        gameOver = spriteSheet.getImage(288, 184, 32, 15);
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
        playerUpFirst = spriteSheet.getImage(0, 0, 15, 15);
        playerUpSecond = spriteSheet.getImage(16, 0, 15, 15);
        playerDownFirst = spriteSheet.getImage(64, 0, 15, 15);
        playerDownSecond = spriteSheet.getImage(80, 0, 15, 15);
        playerLeftFirst = spriteSheet.getImage(35, 0, 15, 15);
        playerLeftSecond = spriteSheet.getImage(50, 0, 15, 15);
        playerRightFirst = spriteSheet.getImage(95, 0, 15, 15);
        playerRightSecond = spriteSheet.getImage(110, 0, 15, 15);
        fullWall = spriteSheet.getImage(256, 0, 15, 15);
        upHalfWall = spriteSheet.getImage(256, 0, 15, 7);
        downHalfWall = spriteSheet.getImage(256, 0, 15, 7);
//        rightHalfWall = spriteSheet.getImage(273, 0, 15, 15);
        rightHalfWall = spriteSheet.getImage(264, 0, 7, 15);
        leftHalfWall = spriteSheet.getImage(256, 0, 7, 15);
        enemy1UpFirst = spriteSheet.getImage(127, 0, 15, 15);
        enemy1UpSecond = spriteSheet.getImage(143, 0, 15, 15);
        enemy1DownFirst = spriteSheet.getImage(191, 0, 15, 15);
        enemy1DownSecond = spriteSheet.getImage(207, 0, 15, 15);
        enemy1LeftFirst = spriteSheet.getImage(160, 0, 15, 15);
        enemy1LeftSecond = spriteSheet.getImage(177, 0, 15, 15);
        enemy1RightFirst = spriteSheet.getImage(223, 0, 15, 15);
        enemy1RightSecond = spriteSheet.getImage(238, 0, 15, 15);
        enemy2UpFirst = spriteSheet.getImage(128, 17, 15, 15);
        enemy2UpSecond = spriteSheet.getImage(143, 17, 15, 15);
        enemy2DownFirst = spriteSheet.getImage(192, 15, 15, 15);
        enemy2DownSecond = spriteSheet.getImage(207, 15, 15, 15);
        enemy2LeftFirst = spriteSheet.getImage(161, 15, 15, 15);
        enemy2LeftSecond = spriteSheet.getImage(176, 15, 15, 15);
        enemy2RightFirst = spriteSheet.getImage(223, 15, 15, 15);
        enemy2RightSecond = spriteSheet.getImage(240, 15, 15, 15);
        enemy3UpFirst = spriteSheet.getImage(129, 32, 15, 15);
        enemy3UpSecond = spriteSheet.getImage(144, 32, 15, 15);
        enemy3DownFirst = spriteSheet.getImage(192, 32, 15, 15);
        enemy3DownSecond = spriteSheet.getImage(207, 32, 15, 15);
        enemy3LeftFirst = spriteSheet.getImage(159, 32, 15, 15);
        enemy3LeftSecond = spriteSheet.getImage(176, 32, 15, 15);
        enemy3RightFirst = spriteSheet.getImage(223, 32, 15, 15);
        enemy3RightSecond = spriteSheet.getImage(240, 32, 15, 15);
        enemy4UpFirst = spriteSheet.getImage(128, 48, 15, 15);
        enemy4UpSecond = spriteSheet.getImage(144, 48, 15, 15);
        enemy4DownFirst = spriteSheet.getImage(192, 48, 15, 15);
        enemy4DownSecond = spriteSheet.getImage(208, 48, 15, 15);
        enemy4LeftFirst = spriteSheet.getImage(160, 48, 15, 15);
        enemy4LeftSecond = spriteSheet.getImage(176, 48, 15, 15);
        enemy4RightFirst = spriteSheet.getImage(224, 48, 15, 15);
        enemy4RightSecond = spriteSheet.getImage(240, 48, 15, 15);
        eagle = spriteSheet.getImage(304, 32, 15, 15);
    }

    public static BufferedImage getEnemy1UpSecond() {
        return enemy1UpSecond;
    }

    public static BufferedImage getEnemy4UpFirst() {
        return enemy4UpFirst;
    }

    public static BufferedImage getEnemy4UpSecond() {
        return enemy4UpSecond;
    }

    public static BufferedImage getEnemy4DownFirst() {
        return enemy4DownFirst;
    }

    public static BufferedImage getEnemy4DownSecond() {
        return enemy4DownSecond;
    }

    public static BufferedImage getEnemy4LeftFirst() {
        return enemy4LeftFirst;
    }

    public static BufferedImage getEnemy4LeftSecond() {
        return enemy4LeftSecond;
    }

    public static BufferedImage getEnemy4RightFirst() {
        return enemy4RightFirst;
    }

    public static BufferedImage getEnemy4RightSecond() {
        return enemy4RightSecond;
    }

    public static BufferedImage getEnemy3UpFirst() {
        return enemy3UpFirst;
    }

    public static BufferedImage getEnemy3UpSecond() {
        return enemy3UpSecond;
    }

    public static BufferedImage getEnemy3DownFirst() {
        return enemy3DownFirst;
    }

    public static BufferedImage getEnemy3DownSecond() {
        return enemy3DownSecond;
    }

    public static BufferedImage getEnemy3LeftFirst() {
        return enemy3LeftFirst;
    }

    public static BufferedImage getEnemy3LeftSecond() {
        return enemy3LeftSecond;
    }

    public static BufferedImage getEnemy3RightFirst() {
        return enemy3RightFirst;
    }

    public static BufferedImage getEnemy3RightSecond() {
        return enemy3RightSecond;
    }

    public static BufferedImage getEnemy2UpFirst() {
        return enemy2UpFirst;
    }

    public static BufferedImage getEnemy2UpSecond() {
        return enemy2UpSecond;
    }

    public static BufferedImage getEnemy2DownFirst() {
        return enemy2DownFirst;
    }

    public static BufferedImage getEnemy2DownSecond() {
        return enemy2DownSecond;
    }

    public static BufferedImage getEnemy2LeftFirst() {
        return enemy2LeftFirst;
    }

    public static BufferedImage getEnemy2LeftSecond() {
        return enemy2LeftSecond;
    }

    public static BufferedImage getEnemy2RightFirst() {
        return enemy2RightFirst;
    }

    public static BufferedImage getEnemy2RightSecond() {
        return enemy2RightSecond;
    }

    public static BufferedImage getEnemy1DownSecond() {
        return enemy1DownSecond;
    }

    public static BufferedImage getEnemy1LeftSecond() {
        return enemy1LeftSecond;
    }

    public static BufferedImage getEnemy1RightSecond() {
        return enemy1RightSecond;
    }

    public static BufferedImage getPlayerDownFirst() {
        return playerDownFirst;
    }

    public static BufferedImage getPlayerLeftFirst() {
        return playerLeftFirst;
    }

    public static BufferedImage getPlayerRightFirst() {
        return playerRightFirst;
    }

    public static BufferedImage getEagle() {
        return eagle;
    }

    public static BufferedImage getEnemy1UpFirst() {
        return enemy1UpFirst;
    }

    public static BufferedImage getFullWall() {
        return fullWall;
    }

    public static BufferedImage getPlayerUpFirst() {
        return playerUpFirst;
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
