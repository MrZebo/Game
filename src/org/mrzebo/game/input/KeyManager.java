package org.mrzebo.game.input;


import org.mrzebo.game.DIRECTION;
import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Bullet;
import org.mrzebo.game.gfx.Assets;
import org.mrzebo.game.levels.Level;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private Game game;


    public KeyManager(Game game) {
        this.game = game;

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case (KeyEvent.VK_UP):
                if (game.getLevel().movable(game.getPlayer(), DIRECTION.UP)) {
                    game.getPlayer().setyMove(-game.getPlayer().getSpeed());
                    game.getPlayer().setDirection(DIRECTION.UP);
                    game.getPlayer().modelRender();
                }
                break;
            case (KeyEvent.VK_DOWN):
                if (game.getLevel().movable(game.getPlayer(), DIRECTION.DOWN)) {
                    game.getPlayer().setyMove(game.getPlayer().getSpeed());
                    game.getPlayer().setDirection(DIRECTION.DOWN);
                    game.getPlayer().modelRender();
                }
                break;
            case (KeyEvent.VK_LEFT):
                if (game.getLevel().movable(game.getPlayer(), DIRECTION.LEFT)) {
                    game.getPlayer().setxMove(-game.getPlayer().getSpeed());
                    game.getPlayer().setDirection(DIRECTION.LEFT);
                    game.getPlayer().modelRender();
                }
                break;
            case (KeyEvent.VK_RIGHT):
                if (game.getLevel().movable(game.getPlayer(), DIRECTION.RIGHT)) {
                    game.getPlayer().setxMove(game.getPlayer().getSpeed());
                    game.getPlayer().setDirection(DIRECTION.RIGHT);
                    game.getPlayer().modelRender();
                }
                break;
            case (KeyEvent.VK_SPACE):
                game.getPlayer().getBullets().add(new Bullet(game.getPlayer(), game.getPlayer().getX(), game.getPlayer().getY(), 10, 10));
                break;
            case (KeyEvent.VK_CONTROL):
                game.pause();
                break;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
