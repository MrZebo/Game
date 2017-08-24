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

    private void init() {
        Assets.init();
        player = new Player(this, Assets.getPlayerUp(), (width / 2) - 50, height / 2);
        level = LevelFactory.getLevel(this, player, getLvl());
//        level.setGame(this);
//        level.setPlayer(player);
        display = new Display(level, title, width, height);
        keyManager = new KeyManager(this);
        display.getCanvas().addKeyListener(keyManager);

    }

    public int move(AbstractUnit unit) {
        if (unit instanceof Player) {
            return 5;
        } else if (unit instanceof Enemy) {
            return 1;
        }
        return 0;
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

    private void gameOver() {
        if (level.getEagle().getLife() <= 0) {
            System.out.println("life is zero");
            g = bs.getDrawGraphics();
            g.clearRect(0, 0, width, height);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);
            g.drawImage(Assets.getGameOver(), width/2, 300, null);
            bs.show();
            g.dispose();
            running = false;
        }
        if (level.getPlayer().getLife() <= 0) {
            System.out.println("life is zero");
            g = bs.getDrawGraphics();
            g.clearRect(0, 0, width, height);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);
            g.drawImage(Assets.getGameOver(), 300, 300, null);
            bs.show();
            g.dispose();
            running = false;
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
//        g.clearRect(0, 0, width, height);
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, width, height);
//        g.setColor(Color.GRAY);
//        g.fillRect(height, 0, 100, height);
        g.clearRect(0, 0, width, height);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(15, 15, blackRectWidth, blackRectHeight);
        player.render(g);
        level.render(g);
        bs.show();
        g.dispose();

    }

    public void run() {
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        init();
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                gameOver();
                delta--;
            }
        }
        stop();
    }
}
