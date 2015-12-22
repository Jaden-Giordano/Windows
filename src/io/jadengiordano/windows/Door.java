package io.jadengiordano.windows;

import io.jadengiordano.windows.items.Key;

/**
 * Created by Jaden on 12/5/2015.
 */
public abstract class Door extends Attachable implements Interactable {

    protected boolean unlocked;
    protected Key.KeyType keyType;

    public Door(World w, int tileID, Key.KeyType keyType) {
        super(w, tileID);

        this.keyType = keyType;

        this.unlocked = true;

        this.color = new Vector4(1f, .5f, .2f, 1f);

        this.setSolid(true);
    }

    // Returns is the door was unlocked.
    public boolean use() {
        if (this.unlocked)
            return false;
        else {
            this.setSolid(false);
            return (this.unlocked = true);
        }
    }

    @Override
    public void setState(boolean state) {
        super.setState(state);

        this.setSolid(!state);
        this.unlocked = state;
    }

    public Key.KeyType getKeyType() {
        return this.keyType;
    }

}
