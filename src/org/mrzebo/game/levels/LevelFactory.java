package org.mrzebo.game.levels;

import org.mrzebo.game.Game;
import org.mrzebo.game.entities.units.Player;

public class LevelFactory {

    public static Level getLevel(Game game, Player player, int level) {
        Level lvl = null;
        switch (level) {
            case (0):
                lvl = new Level1(game, player);
                break;
            case (1):
                break;

        }
        return lvl;
    }
}
