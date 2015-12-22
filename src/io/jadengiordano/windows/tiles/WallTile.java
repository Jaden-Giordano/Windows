package io.jadengiordano.windows.tiles;

import io.jadengiordano.windows.Tile;
import io.jadengiordano.windows.Vector4;
import io.jadengiordano.windows.World;

/**
 * Created by Jaden on 12/2/2015.
 */
public class WallTile extends Tile {

    public WallTile(World w, int tileID) {
        super(w, tileID);

        this.setSolid(true);
        this.color = new Vector4(0, 1, 0, 1);
    }

}
