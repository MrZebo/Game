package org.mrzebo.game.levels;

public class LevelFactory {

    public static Level getLevel(int level) {
        Level lvl = null;
        switch (level) {
            case (0):
                lvl = new Level1();
                break;
            case (1):
                break;

        }
        return lvl;
    }
}
