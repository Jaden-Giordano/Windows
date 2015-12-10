package io.jadengiordano.windows.tiles;

import io.jadengiordano.windows.InteractableTile;
import io.jadengiordano.windows.Tile;
import io.jadengiordano.windows.Vector4;
import io.jadengiordano.windows.Windows;
import io.jadengiordano.windows.objects.Player;

/**
 * Created by Jaden on 12/9/2015.
 */
public class NextLevelTile extends Tile implements InteractableTile {

    public NextLevelTile(int tileID) {
        super(tileID);

        this.color = new Vector4(18f / 255f, 173f / 255f, 109f / 255f, 1);
    }

    @Override
    public void movedThrough(Player p) {
        Windows.instance.getGame().getCurrentGameSet().nextLevel();
    }
}
