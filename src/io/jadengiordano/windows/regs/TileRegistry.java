package io.jadengiordano.windows.regs;

import io.jadengiordano.windows.Tile;
import io.jadengiordano.windows.World;
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

    public static Tile getTile(World w, int tileID) {
        if (tileID == Tiles.WALL.ordinal())
            return new WallTile(w, tileID);
        if (tileID == Tiles.RED_GLASS.ordinal())
            return new RedGlass(w, tileID);
        if (tileID == Tiles.GREEN_GLASS.ordinal())
            return new GreenGlass(w, tileID);
        if (tileID == Tiles.BLUE_GLASS.ordinal())
            return new BlueGlass(w, tileID);
        if (tileID == Tiles.BLACK_GLASS.ordinal())
            return new BlackGlass(w, tileID);
        if (tileID == Tiles.GOLD_DOOR.ordinal())
            return new GoldDoor(w, tileID);
        if (tileID == Tiles.ORANGE_GLASS.ordinal())
            return new OrangeGlass(w, tileID);
        if (tileID == Tiles.YELLOW_GLASS.ordinal())
            return new YellowGlass(w, tileID);
        if (tileID == Tiles.VIOLET_GLASS.ordinal())
            return new VioletGlass(w, tileID);
        if (tileID == Tiles.NEXT_LEVEL_TILE.ordinal())
            return new NextLevelTile(w, tileID);
        return new DefaultTile(w, -1);
    }

}
