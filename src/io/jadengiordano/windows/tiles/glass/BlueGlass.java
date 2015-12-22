package io.jadengiordano.windows.tiles.glass;

import io.jadengiordano.windows.Color;
import io.jadengiordano.windows.Vector4;
import io.jadengiordano.windows.World;
import io.jadengiordano.windows.objects.Player;
import io.jadengiordano.windows.tiles.GlassTile;

/**
 * Created by Jaden on 12/5/2015.
 */
public class BlueGlass extends GlassTile {

    public BlueGlass(World w, int tileID) {
        super(w, tileID, Color.BLUE);

        this.color = new Vector4(0, 0, 1, 1);
    }

    @Override
    public void movedThrough(Player p) {
        super.movedThrough(p);

        //p.setSpeed(90f);
    }

}
