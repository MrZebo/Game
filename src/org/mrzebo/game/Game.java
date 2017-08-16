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
    public int PLAYER_MOVE = 5;
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
    private Enemy enemy;

    public static int getLvl() {
        return lvl;
    }

    public static void setLvl(int lvl) {
        Game.lvl = lvl;
    }

    Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public Display getDisplay() {
        return display;
    }

    public Level getLevel() {
        return level;
    }

    private void init() {
        Assets.init();
        level = LevelFactory.getLevel(getLvl());
        display = new Display(level, title, width, height);
        keyManager = new KeyManager(this);
        display.getCanvas().addKeyListener(keyManager);
        player = new Player(this, Assets.getPlayerUp(), width / 2, height / 2);
        level.setEnemy(enemy);
        level.setGame(this);
        level.setPlayer(player);
        enemy = new Enemy(this, level, Assets.getEnemyDown(), 330, 0, 15, 15);

    }

    public int move(AbstractUnit unit) {
        if (unit instanceof Player) {
            return 5;
        } else if (unit instanceof Enemy) {
            return 5;
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
        enemy.tick();

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
//        g.drawImage(Assets.getFullWall(), 150, 150, null);
//        g.drawImage(Assets.getEnemyUp(), 450, 450, null);
//        g.drawImage(Assets.getEagle(), 350, 200, null);
//        g.drawImage(Assets.getBulletUp(), 450, 300, null);
        g.drawImage(Assets.getExplosive()[0], 300, 450, null);
        g.drawImage(Assets.getExplosive()[1], 330, 450, null);
        g.drawImage(Assets.getExplosive()[2], 350, 450, null);
//        g.drawImage(Assets.getPlayerUp(), 400, 400, null);
        g.drawImage(Assets.getFullWhiteWall(), 400, 400, null);
        player.render(g);
        level.render(g);
        enemy.render(g);
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
                delta--;
            }
        }
        stop();
    }
}
