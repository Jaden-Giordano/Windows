package io.jadengiordano.windows.regs;

import io.jadengiordano.windows.Tile;
import io.jadengiordano.windows.objects.doors.GoldDoor;
import io.jadengiordano.windows.tiles.DefaultTile;
import io.jadengiordano.windows.tiles.NextLevelTile;
import io.jadengiordano.windows.tiles.WallTile;
import io.jadengiordano.windows.tiles.glass.*;

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
        ORANGE_GLASS,
        YELLOW_GLASS,
        VIOLET_GLASS,
        NEXT_LEVEL_TILE
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
        if (tileID == Tiles.ORANGE_GLASS.ordinal())
            return new OrangeGlass(tileID);
        if (tileID == Tiles.YELLOW_GLASS.ordinal())
            return new YellowGlass(tileID);
        if (tileID == Tiles.VIOLET_GLASS.ordinal())
            return new VioletGlass(tileID);
        if (tileID == Tiles.NEXT_LEVEL_TILE.ordinal())
            return new NextLevelTile(tileID);
        return new DefaultTile(-1);
    }

}
