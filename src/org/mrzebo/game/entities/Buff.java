package org.mrzebo.game.entities;

<<<<<<< HEAD
import org.mrzebo.game.entities.units.Enemy;
import org.mrzebo.game.gfx.Assets;
import org.mrzebo.game.levels.Level;

=======
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281
import java.awt.*;

public class Buff extends Entity {
    private boolean blink;
<<<<<<< HEAD
    private Level level;
    private Image image;

    public Buff(Level level, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.level = level;
        image = Assets.getBuffStar();
=======

    public Buff(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281
        blink = true;
    }

    @Override
    public void tick() {
        if (blink) {
            blink = false;
        } else {
            blink = true;
        }
<<<<<<< HEAD
        for (Enemy enemy : level.getEnemies()) {
            if (enemy.getX() == x && enemy.getY() == y) {
                enemy.levelObserver(true);
                level.setBuff(null);
                break;
            }

        }
        if(level.getPlayer().getX() == x && level.getPlayer().getY() == y){
            System.out.println("Player lvl up!");
        }


=======
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281
    }

    @Override
    public void render(Graphics g) {
<<<<<<< HEAD
        if (blink) {
=======
        if(blink){
>>>>>>> 1e8deff8eaf29f385201ee220f73d6c83dc21281
            g.drawImage(image, x, y, null);
        }
    }
}
