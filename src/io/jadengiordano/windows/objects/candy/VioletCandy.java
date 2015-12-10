package io.jadengiordano.windows.objects.candy;

import io.jadengiordano.windows.Candy;
import io.jadengiordano.windows.Color;
import io.jadengiordano.windows.Vector3;
import io.jadengiordano.windows.Vector4;
import io.jadengiordano.windows.objects.Player;

/**
 * Created by Jaden on 12/9/2015.
 */
public class VioletCandy extends Candy {

    public VioletCandy(Vector3 pos) {
        super(pos);

        this.color = new Vector4(128f / 255f, 0, 128f / 255f, 1);
    }

    @Override
    public void pickUp(Player p) {
        super.pickUp(p);

        p.setColour(Color.VIOLET);
    }
}
