package io.jadengiordano.windows.objects.candy;

import io.jadengiordano.windows.*;
import io.jadengiordano.windows.objects.Player;

/**
 * Created by Jaden on 12/9/2015.
 */
public class VioletCandy extends Candy {

    public VioletCandy(World w, Vector3 pos) {
        super(w, pos);

        this.color = new Vector4(128f / 255f, 0, 128f / 255f, 1);
    }

    @Override
    public void pickUp(Player p) {
        super.pickUp(p);

        p.setColour(Color.VIOLET);
    }
}
