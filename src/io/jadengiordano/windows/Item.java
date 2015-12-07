package io.jadengiordano.windows;

import io.jadengiordano.windows.items.Key;
import io.jadengiordano.windows.objects.Player;

/**
 * Created by Jaden on 12/5/2015.
 */
public abstract class Item extends PickUp {

    private int id;

    public Item(int id) {
        this.id = id;

        this.transform.setScale(new Vector2(20, 20));
    }

    public int getID() {
        return id;
    }

    @Override
    public void pickUp(Player p) {
        super.pickUp(p);

        if (this instanceof Key)
            System.out.println("pickup");
        p.getInventory().addItem(this);
    }
}
