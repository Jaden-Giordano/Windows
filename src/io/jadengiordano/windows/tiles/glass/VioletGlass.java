package io.jadengiordano.windows.tiles.glass;

import io.jadengiordano.windows.Color;
import io.jadengiordano.windows.Vector4;
import io.jadengiordano.windows.World;
import io.jadengiordano.windows.tiles.GlassTile;

/**
 * Created by Jaden on 12/9/2015.
 */
public class VioletGlass extends GlassTile {

    public VioletGlass(World w, int tileID) {
        super(w, tileID, Color.VIOLET);

        this.color = new Vector4(128f / 255f, 0, 128f / 255f, 1);
    }

}
