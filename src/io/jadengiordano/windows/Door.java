package io.jadengiordano.windows;

import io.jadengiordano.windows.items.Key;

/**
 * Created by Jaden on 12/5/2015.
 */
public abstract class Door extends Tile {

    protected boolean unlocked;
    protected Key.KeyType keyType;

    public Door(int tileID, Key.KeyType keyType) {
        super(tileID);

        this.keyType = keyType;

        this.unlocked = true;

        this.color = new Vector4(1f, .5f, .2f, 1f);

        this.setSolid(true);
    }

    // Returns is the door was unlocked.
    public boolean unlock() {
        if (this.unlocked)
            return false;
        else {
            this.setSolid(false);
            return (this.unlocked = true);
        }
    }

    public Key.KeyType getKeyType() {
        return this.keyType;
    }

}
