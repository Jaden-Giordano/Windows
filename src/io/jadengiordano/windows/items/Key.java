package io.jadengiordano.windows.items;

import io.jadengiordano.windows.Door;
import io.jadengiordano.windows.Interactable;
import io.jadengiordano.windows.Item;
import io.jadengiordano.windows.World;

/**
 * Created by Jaden on 12/5/2015.
 */
public class Key extends Item {

    public enum KeyType {
        GOLD
    }

    protected KeyType keyType;

    public Key(World w, int id, KeyType keyType) {
        super(w, id);

        this.keyType = keyType;
    }

    public void use(Interactable door) {
        if (((Door) door).getKeyType().ordinal() == this.keyType.ordinal()) {
            System.out.println("Key used");
            door.use();
            this.inv_rmv = true;
        }
    }

}
