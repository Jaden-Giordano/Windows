package io.jadengiordano.windows.regs;

import io.jadengiordano.windows.Item;
import io.jadengiordano.windows.World;
import io.jadengiordano.windows.items.DefaultItem;
import io.jadengiordano.windows.items.Key;

/**
 * Created by Jaden on 12/5/2015.
 */
public class ItemRegistry {

    public static enum Items {
        GOLD_KEY
    }

    public static Item getItem(World w, int itemID) {
        if (itemID == Items.GOLD_KEY.ordinal())
            return new Key(w, itemID, Key.KeyType.GOLD);
        return new DefaultItem(w, -1);
    }

}
