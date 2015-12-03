package io.jadengiordano.windows;

import io.jadengiordano.windows.tiles.DefaultTile;
import io.jadengiordano.windows.tiles.WallTile;

/**
 * Created by Jaden on 12/2/2015.
 */
public class TileRegistry {

    public static enum Tiles {
        WALL,
        GLASS
    }

    public static Tile getTile(int tileID) {
        if (tileID == Tiles.WALL.ordinal())
            return new WallTile(tileID);
        return new DefaultTile(-1);
    }

}
