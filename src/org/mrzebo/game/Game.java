package org.mrzebo.game;

import org.mrzebo.game.display.Display;
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.entities.units.Player;
import org.mrzebo.game.entities.units.AbstractUnit;
import org.mrzebo.game.gfx.Assets;
import org.mrzebo.game.input.KeyManager;
import org.mrzebo.game.levels.Level;
import org.mrzebo.game.levels.LevelFactory;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private int width;
    private int height;
    private int blackRectWidth;
    private int blackRectHeight;
    private static int lvl = 0;
    private String title;
    private Display display;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    private KeyManager keyManager;
    private Player player;
    private Level level;
    private boolean pause = false;
    private STATEMENT statement;
    private Start_menu menu;

    public static int getLvl() {
        return lvl;
    }

    public static void lvlUp() {
        lvl++;
    }

    Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        blackRectWidth = width - 115;
        blackRectHeight = height - 30;
    }

    public Display getDisplay() {
        return display;
    }

    public Level getLevel() {
        return level;
    }

    public void setStatement(STATEMENT statement) {
        this.statement = statement;
    }

    private void init() {
        Assets.init();
        statement = STATEMENT.START_MENU;
        menu = new Start_menu(this);
        player = new Player(this, (width / 2) - 50, height / 2);
        level = LevelFactory.getLevel(this, player, getLvl());
        display = new Display(level, title, width, height);
        keyManager = new KeyManager(this);
        display.getCanvas().addKeyListener(keyManager);

    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public Player getPlayer() {
        return player;
    }

    synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        if (pause) {
            pause = false;
        } else {
            pause = true;
        }
    }

    private synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void tick() {
        player.tick();
        level.tick();
    }


    private void gameOver(Graphics g) {
        g.clearRect(0, 0, width, height);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(15, 15, blackRectWidth, blackRectHeight);
        g.drawImage(Assets.getGameOver(), blackRectWidth / 2, blackRectHeight / 2, null);
<<<<<<< HEAD
//        bs.show();
=======
<<<<<<< HEAD
//        bs.show();
=======
        bs.show();
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281
>>>>>>> 5088eeef8d6b4cf3d0efa6820fca2c5aaa946123
        g.dispose();
        running = false;
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 5088eeef8d6b4cf3d0efa6820fca2c5aaa946123
        }
        if (statement == STATEMENT.START_MENU) {
            g = bs.getDrawGraphics();
            g.clearRect(0, 0, width, height);
            g.fillRect(0, 0, width, height);
            g.setColor(Color.BLACK);
            menu.render(g);
            display.getCanvas().addKeyListener(menu);
            bs.show();
            g.dispose();
        }
        if (statement == STATEMENT.GAME) {
            g = bs.getDrawGraphics();
            g.clearRect(0, 0, width, height);
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, width, height);
            g.setColor(Color.BLACK);
            g.fillRect(15, 15, blackRectWidth, blackRectHeight);
            player.render(g);
            level.render(g);
            if (level.getEagle().getLife() <= 0 || player.getLife() <= 0) {
                gameOver(g);
            }
            bs.show();
            g.dispose();
<<<<<<< HEAD
        }
=======
        }
=======
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(15, 15, blackRectWidth, blackRectHeight);
        player.render(g);
        level.render(g);
        if (level.getEagle().getLife() <= 0 || player.getLife() <= 0) {
            gameOver(g);
        }
        bs.show();
        g.dispose();
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281
>>>>>>> 5088eeef8d6b4cf3d0efa6820fca2c5aaa946123

    }

    public void run() {
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        init();
        int a = 0;
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            if (delta >= 1) {
                if (statement == STATEMENT.GAME && !pause) tick();
                render();
                delta--;
            }
        }
        stop();
    }
}
