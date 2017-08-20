

package org.mrzebo.game.levels;

import org.mrzebo.game.DIRECTION;
import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Eagle;
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.entities.Entity;
import org.mrzebo.game.entities.units.Player;
import org.mrzebo.game.entities.units.AbstractUnit;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Level {
    private CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<AbstractUnit> units = new CopyOnWriteArrayList<>();
    private Player player;
    private Canvas canvas = new Canvas();
    protected int enemyCount;
    //    protected Enemy[] enemies;
    protected CopyOnWriteArrayList<Enemy> enemies;
    protected Eagle eagle;
    protected Game game;

    public void tick() {

    }

    public Eagle getEagle() {
        return eagle;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public void lowerEnemyCount() {
        enemyCount -= 1;
    }

    public boolean movable(AbstractUnit unit, DIRECTION direction) {
        int move;
        if (unit instanceof Player) {
            move = game.move(unit);
        } else {
            move = game.move(unit) + 4;
        }
        switch (direction) {
            case UP:
                unit.setDirection(DIRECTION.UP);
                if (unit.getY() - move <= -5) {
//                if (unit.getY() - unit.getGame().move(unit) <= 0) {
                    return false;
                }
                for (Entity entity : entities) {
                    int variable = entity.getLife() < 2 ? 5 : 10;

                    if (unit.getY() == entity.getY() + variable + move && unit.getX() == entity.getX() + move * 2) {
                        //y == getY + 10 + 5 && x == getX + 5 *2
                        //y == getY + 10 + 1 && x == getX + 1 * 2
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
                if (unit.getY() + move >= 590) {
//                if (unit.getY() + unit.getGame().move(unit) >= 585) {
                    return false;
                }
                for (Entity entity : entities) {
                    int variable = entity.getLife() < 2 ? 5 : 10;
//                    int variable = 14;
                    if (unit.getY() == entity.getY() - variable - move && unit.getX() == entity.getX() + move * 2) {
                        return false;
                        // y == getY - 10 - 5 && x == getX + 5 * 2
                        //y == getY - 12 - 1 && x == getX + 1 * 2
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
                if (unit.getX() - move <= -5) {
//                if (unit.getX() - unit.getGame().move(unit) <= 0) {
                    return false;
                }
                for (Entity entity : entities) {
                    int variable = entity.getLife() < 2 ? 5 : 10;
                    if (unit.getX() <= 0) return false;
                    if (unit.getX() == entity.getX() + variable + move && unit.getY() == entity.getY() - move * 2) {
                        return false;
                        //x == getX + 10 + 5 && y == getY - 5 *2
                        //x = getx + 10 + 5 && Y == GETy - 5 *2
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
                if (unit.getX() + move >= 590) {
//                if (unit.getX() + unit.getGame().move(unit) >= 585) {
                    return false;
                }
                for (Entity entity : entities) {
                    int variable = entity.getLife() < 2 ? 5 : 10;
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

    public CopyOnWriteArrayList<Enemy> getEnemies() {
        return enemies;
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

