package io.jadengiordano.windows.tiles;

import io.jadengiordano.windows.Tile;
import io.jadengiordano.windows.Vector4;
import io.jadengiordano.windows.World;

/**
 * Created by Jaden on 12/2/2015.
 */
public class DefaultTile extends Tile {

    public DefaultTile(World w, int tileID) {
        super(w, tileID);

        this.color = new Vector4(1, 1, 1, 1);
    }

}
