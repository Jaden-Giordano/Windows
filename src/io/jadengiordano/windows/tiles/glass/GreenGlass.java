package io.jadengiordano.windows.tiles.glass;

import io.jadengiordano.windows.Color;
import io.jadengiordano.windows.objects.Player;
import io.jadengiordano.windows.tiles.GlassTile;

/**
 * Created by Jaden on 12/5/2015.
 * <p>
 * Sets color to black
 */
public class GreenGlass extends GlassTile {

    public GreenGlass(int tileID) {
        super(tileID, Color.GREEN);
    }

    @Override
    public void movedThrough(Player p) {
        super.movedThrough(p);

        //p.setColor(Color.BLACK);
    }

}
