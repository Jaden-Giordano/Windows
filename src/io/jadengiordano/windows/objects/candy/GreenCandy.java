package io.jadengiordano.windows.objects.candy;

import io.jadengiordano.windows.*;
import io.jadengiordano.windows.objects.Player;

/**
 * Created by Jaden on 12/9/2015.
 */
public class GreenCandy extends Candy {

    public GreenCandy(World w, Vector3 pos) {
        super(w, pos);

        this.color = new Vector4(0, 1, 0, 1);
    }

    @Override
    public void pickUp(Player p) {
        super.pickUp(p);

        p.setColour(Color.GREEN);
    }
}
