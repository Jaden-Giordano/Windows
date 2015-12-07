package io.jadengiordano.windows.regs;

import io.jadengiordano.windows.Tile;
import io.jadengiordano.windows.objects.doors.GoldDoor;
import io.jadengiordano.windows.tiles.DefaultTile;
import io.jadengiordano.windows.tiles.WallTile;
import io.jadengiordano.windows.tiles.glass.BlackGlass;
import io.jadengiordano.windows.tiles.glass.BlueGlass;
import io.jadengiordano.windows.tiles.glass.GreenGlass;
import io.jadengiordano.windows.tiles.glass.RedGlass;

/**
 * Created by Jaden on 12/2/2015.
 */
public class TileRegistry {

    public static enum Tiles {
        WALL,
        RED_GLASS,
        GREEN_GLASS,
        BLUE_GLASS,
        BLACK_GLASS,
        GOLD_DOOR,
    }

    public static Tile getTile(int tileID) {
        if (tileID == Tiles.WALL.ordinal())
            return new WallTile(tileID);
        if (tileID == Tiles.RED_GLASS.ordinal())
            return new RedGlass(tileID);
        if (tileID == Tiles.GREEN_GLASS.ordinal())
            return new GreenGlass(tileID);
        if (tileID == Tiles.BLUE_GLASS.ordinal())
            return new BlueGlass(tileID);
        if (tileID == Tiles.BLACK_GLASS.ordinal())
            return new BlackGlass(tileID);
        if (tileID == Tiles.GOLD_DOOR.ordinal())
            return new GoldDoor(tileID);
        return new DefaultTile(-1);
    }

}
