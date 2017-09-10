

package org.mrzebo.game.levels;

import org.mrzebo.game.DIRECTION;
import org.mrzebo.game.Game;
import org.mrzebo.game.entities.Buff;
import org.mrzebo.game.entities.Eagle;
import org.mrzebo.game.entities.Entity;
import org.mrzebo.game.entities.units.AbstractUnit;
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.entities.units.Player;
<<<<<<< HEAD
import org.mrzebo.game.gfx.Assets;
=======
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Level {
    private CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList();
    private Player player;
    private Canvas canvas;
    protected int enemyCount;
<<<<<<< HEAD
=======
    //    protected Enemy[] enemies;
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281
    protected Buff buff;
    protected int buffCount;
    protected CopyOnWriteArrayList<Enemy> enemies;
    protected Eagle eagle;
    protected Game game;

    abstract void buffObserver();
<<<<<<< HEAD
=======

    public Eagle getEagle() {
        return eagle;
    }
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281

    public Buff getBuff() {
        return buff;
    }

    public void setBuff(Buff buff) {
        this.buff = buff;
    }

    public boolean movable(AbstractUnit unit, DIRECTION direction) {
        int move = unit.getSpeed();
        switch (direction) {
            case UP:
                unit.setDirection(DIRECTION.UP);
                switch (unit.getSpeed()) {
                    case 1:
                        if (unit.getY() - move <= 14) {
                            return false;
                        }
                        for (Entity entity : entities) {
                            for (int i = 0; i <= 14; i++) {
                                if (unit.getX() == entity.getX() - move * i && unit.getY() == entity.getY() + 14 + move) {
                                    return false;
                                }
                                if (unit.getX() == entity.getX() + move * i && unit.getY() == entity.getY() + 14 + move) {
                                    return false;
                                }
                            }
                            if (unit.getX() == entity.getX() && unit.getY() == entity.getY() + 14 + move) {
                                return false;
                            }
                        }
                        break;
                    case 3:
                        break;
                    case 5:
                        if (unit.getY() - move <= 10) {
                            return false;
                        }
                        for (Entity entity : entities) {
                            int variable = entity.getLife() < 2 ? 5 : 10;

                            if (unit.getY() == entity.getY() + variable + move && unit.getX() == entity.getX() + move * 2) {
                                return false;
                            }
                            if (unit.getY() == entity.getY() + variable + move && unit.getX() == entity.getX() - move * 2) {
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
                }

                break;
            case DOWN:
                unit.setDirection(DIRECTION.DOWN);
                switch (unit.getSpeed()) {
                    case 1:
                        if (unit.getY() + move >= 570) {
                            return false;
                        }
                        for (Entity entity : entities) {
                            for (int i = 0; i <= 14; i++) {
                                if (unit.getX() == entity.getX() - move * i && unit.getY() == entity.getY() - 14 - move) {
                                    return false;
                                }
                                if (unit.getX() == entity.getX() + move * i && unit.getY() == entity.getY() - 14 - move) {
                                    return false;
                                }
                            }
                            if (unit.getX() == entity.getX() && unit.getY() == entity.getY() - 14 - move) {
                                return false;
                            }

                        }
                        break;
                    case 3:
                        break;
                    case 5:
                        if (unit.getY() + move >= 575) {
                            return false;
                        }
                        for (Entity entity : entities) {
                            int variable = entity.getLife() < 2 ? 5 : 10;
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
                }

                break;
            case LEFT:
                unit.setDirection(DIRECTION.LEFT);
                switch (unit.getSpeed()) {
                    case 1:
                        if (unit.getX() - move <= 14) {
                            return false;
                        }
                        for (Entity entity : entities) {
                            for (int i = 0; i <= 14; i++) {
                                if (unit.getX() == entity.getX() + 14 + move && unit.getY() == entity.getY() - move * i) {
                                    return false;
                                }
                                if (unit.getX() == entity.getX() + 14 + move && unit.getY() == entity.getY() + move * i) {
                                    return false;
                                }
                            }
                            if (unit.getX() == entity.getX() + 14 + move && unit.getY() == entity.getY()) {
                                return false;
                            }
                        }
                        break;
                    case 3:
                        break;
                    case 5:
                        if (unit.getX() - move <= 10) {
                            return false;
                        }
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
                }

                break;
            case RIGHT:
                unit.setDirection(DIRECTION.RIGHT);
                switch (unit.getSpeed()) {
                    case 1:
                        if (unit.getX() + move >= 586) {
                            return false;
                        }
                        for (Entity entity : entities) {
                            for (int i = 0; i <= 14; i++) {
                                if (unit.getX() == entity.getX() - 14 - move && unit.getY() == entity.getY() - move * i) {
                                    return false;
                                }
                                if (unit.getX() == entity.getX() - 14 - move && unit.getY() == entity.getY() + move * i) {
                                    return false;
                                }
                            }
                            if (unit.getX() == entity.getX() - 14 - move && unit.getY() == entity.getY()) {
                                return false;
                            }
                        }
                        break;
                    case 3:
                        break;
                    case 5:
                        if (unit.getX() + move >= 590) {
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

                break;
        }
        return true;
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

    public CopyOnWriteArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
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

    Level(Game game, Player player) {
        this.game = game;
        this.player = player;

    }

    abstract void init();

    public abstract void tick();

    public abstract void render(Graphics g);
}

