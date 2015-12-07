package io.jadengiordano.windows.tiles.glass;

import io.jadengiordano.windows.Color;
import io.jadengiordano.windows.Vector4;
import io.jadengiordano.windows.objects.Player;
import io.jadengiordano.windows.tiles.GlassTile;

/**
 * Created by Jaden on 12/4/2015.
 * <p>
 * Makes move faster
 */
public class RedGlass extends GlassTile {

    public RedGlass(int tileID) {
        super(tileID, Color.RED);

        this.color = new Vector4(1f, 0, 0, 1f);
    }

    @Override
    public void movedThrough(Player p) {
        super.movedThrough(p);

        p.setSpeed(120f);
    }
}
