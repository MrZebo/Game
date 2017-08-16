package org.mrzebo.game.levels;

import org.mrzebo.game.entities.Eagle;
import org.mrzebo.game.entities.Entity;
import org.mrzebo.game.entities.Wall;
import org.mrzebo.game.gfx.Assets;

import java.awt.*;

public class Level1 extends Level {
    private Canvas canvas;


    Level1() {
        enemyCount = 15;
        init();
    }

    @Override
    public void tick() {

    }

    public void init() {
        canvas = new Canvas();
        getEntities().add(new Eagle(Assets.getEagle(), 300, 585, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 0, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 15, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 30, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 45, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 60, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 75, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 90, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 105, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 120, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 135, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 150, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 165, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 180, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 195, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 210, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 225, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 240, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 255, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 270, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 285, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 300, 570, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 0, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 15, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 30, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 45, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 60, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 75, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 90, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 105, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 120, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 135, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 150, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 165, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 180, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 195, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 210, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 225, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 240, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 255, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 270, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 285, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 300, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 315, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 330, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 345, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 360, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 375, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 390, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 405, 555, 15, 15));
        getEntities().add(new Wall(Assets.getFullWall(), 420, 555, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 285, 555, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 315, 555, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 285, 570, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 315, 570, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 285, 585, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 315, 585, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 300, 570, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 300, 555, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 0, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 15, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 30, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 45, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 60, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 75, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 90, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 105, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 120, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 135, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 150, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 165, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 180, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 195, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 210, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 225, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 240, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 255, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 270, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 285, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 300, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 315, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 330, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 150, 330, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 0, 345, 15, 15));
        this.getEntities().add(new Wall(Assets.getFullWall(), 300, 250, 15, 15));
        this.getEntities().add(new Wall(Assets.getDownHalfWall(), 330, 260, 15, 15));
        this.getEntities().add(new Wall(Assets.getUpHalfWall(), 350, 270, 15, 15));
        this.getEntities().add(new Wall(Assets.getWood(), 200, 345, 15, 15));

    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void render(Graphics g) {
//        enemy.render(g);
        for (Entity entity : getEntities()) {
//            g.drawImage(entity.getImage(), entity.getX(), entity.getY(), null);
            if (entity.isNotShot()) {
                entity.render(g);
            } else {
                getEntities().remove(entity);
            }
        }
    }

}
