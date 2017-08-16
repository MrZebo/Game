

package org.mrzebo.game.levels;

import org.mrzebo.game.DIRECTION;
import org.mrzebo.game.Game;
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.entities.Entity;
import org.mrzebo.game.entities.units.Player;
import org.mrzebo.game.entities.units.AbstractUnit;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Level {
    private CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList();
    private Canvas canvas = new Canvas();
    private Player player;
    protected int enemyCount;
    protected Enemy enemy;
    protected Game game;

    public void tick() {

    }

    public boolean movable(AbstractUnit unit, DIRECTION direction) {
        int move = game.move(unit);
        switch (direction) {
            case UP:
                unit.setDirection(DIRECTION.UP);
                for (Entity entity : entities) {
                    int variable = entity.getLife() < 2 ? 5 : 10;
                    if (unit.getY() <= 0) return false;
                    if (unit.getY() == entity.getY() + variable + move && unit.getX() == entity.getX() + move * 2) {
                        return false;
                    }
                    if (unit.getY() == entity.getY() + variable + move && unit.getX() == entity.getX() - move * 2) {
                        System.out.println(variable);
                        return false;
                    }

                    if (unit.getY() == entity.getY() + variable + move && unit.getX() == entity.getX() + move) {
                        return false;
                    }

                    if (unit.getY() == entity.getY() + variable + move && unit.getX() == entity.getX() - move) {
                        return false;
                    }

                    if (unit.getY() == entity.getY() + variable + move && unit.getX() == entity.getX()) {
                        return false;
                    }
                }
                break;
            case DOWN:
                unit.setDirection(DIRECTION.DOWN);
                for (Entity entity : entities) {
                    int variable = entity.getLife() < 2 ? 5 : 10;
                    if (unit.getY() >= 585) return false;
                    if (unit.getY() == entity.getY() - variable - move && unit.getX() == entity.getX() + move * 2) {
                        return false;
                    }

                    if (unit.getY() == entity.getY() - variable - move && unit.getX() == entity.getX() - move * 2) {
                        return false;
                    }

                    if (unit.getY() == entity.getY() - variable - move && unit.getX() == entity.getX() + move) {
                        return false;
                    }

                    if (unit.getY() == entity.getY() - variable - move && unit.getX() == entity.getX() - move) {
                        return false;
                    }
                    if (unit.getY() == entity.getY() - variable - move && unit.getX() == entity.getX()) {
                        return false;
                    }

                }
                break;
            case LEFT:
                unit.setDirection(DIRECTION.LEFT);
                for (Entity entity : entities) {
                    int variable = entity.getLife() < 2 ? 5 : 10;
                    if (unit.getX() <= 0) return false;
                    if (unit.getX() == entity.getX() + variable + move && unit.getY() == entity.getY() - move * 2) {
                        return false;
                    }
                    if (unit.getX() == entity.getX() + variable + move && unit.getY() == entity.getY() + move * 2) {
                        return false;
                    }

                    if (unit.getX() == entity.getX() + variable + move && unit.getY() == entity.getY() - move) {
                        return false;
                    }
                    if (unit.getX() == entity.getX() - variable - move && unit.getY() == entity.getY() - move) {
                        return false;

                    }
                    if (entity.getX() == unit.getX() - variable - move && entity.getY() == unit.getY()) {
                        return false;
                    }
                }
                break;
            case RIGHT:
                unit.setDirection(DIRECTION.RIGHT);
                for (Entity entity : entities) {
                    int variable = entity.getLife() < 2 ? 5 : 10;
                    if (unit.getX() >= 585) return false;
                    if (unit.getX() == entity.getX() - variable - move && unit.getY() == entity.getY() - move * 2) {
                        return false;
                    }
                    if (unit.getX() == entity.getX() - variable - move && unit.getY() == entity.getY() + move * 2) {
                        return false;
                    }

                    if (unit.getX() == entity.getX() - variable - move && unit.getY() == entity.getY() + move) {
                        return false;
                    }
                    if (unit.getX() == entity.getX() - variable - move && unit.getY() == entity.getY() - move) {
                        return false;

                    }
                    if (entity.getX() == unit.getX() + variable + move && entity.getY() == unit.getY()) {
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CopyOnWriteArrayList<Entity> getEntities() {
        return this.entities;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    Level() {
    }

    abstract void init();

    public abstract void render(Graphics var1);
}

