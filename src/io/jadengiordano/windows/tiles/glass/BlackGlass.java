package io.jadengiordano.windows.tiles.glass;

import io.jadengiordano.windows.Color;
import io.jadengiordano.windows.World;
import io.jadengiordano.windows.objects.Player;
import io.jadengiordano.windows.tiles.GlassTile;

/**
 * Created by aidan on 12/5/2015.
 */
public class BlackGlass extends GlassTile {
    public BlackGlass(World w, int tileID) {
        super(w, tileID, Color.BLACK);
    }

    @Override
    public void movedThrough(Player p) {
        super.movedThrough(p);

        //p.setColour(Color.NIGGER);
    }
}

