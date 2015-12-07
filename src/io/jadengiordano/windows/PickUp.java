package io.jadengiordano.windows;

import io.jadengiordano.windows.objects.Player;

/**
 * Created by Jaden on 12/5/2015.
 */
public abstract class PickUp extends GameObject {

    protected PickUp() {
        super();
    }

    public void pickUp(Player p) {
        this.remove = true;
    }

}
