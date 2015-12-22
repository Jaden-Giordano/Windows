package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/6/2015.
 */
public class Attachable extends Tile {

    protected boolean state;

    public Attachable(World w, int tileID) {
        super(w, tileID);
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
