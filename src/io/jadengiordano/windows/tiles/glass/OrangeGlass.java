package io.jadengiordano.windows.tiles.glass;

import io.jadengiordano.windows.Color;
import io.jadengiordano.windows.Vector4;
import io.jadengiordano.windows.World;
import io.jadengiordano.windows.tiles.GlassTile;

/**
 * Created by Jaden on 12/9/2015.
 */
public class OrangeGlass extends GlassTile {
    public OrangeGlass(World w, int tileID) {
        super(w, tileID, Color.ORANGE);

        this.color = new Vector4(1, 165f / 255f, 0, 1);
    }
}
