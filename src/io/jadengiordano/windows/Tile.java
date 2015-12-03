package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/2/2015.
 */
public abstract class Tile extends GameObject {

    private boolean solid;

    private int tileID;

    public Tile(int tileID) {
        super();

        solid = false;
        this.tileID = tileID;
        this.transform.setScale(new Vector2(50, 50));
    }

    public void setSolid(boolean s) {
        this.solid = s;
    }

    public boolean isSolid() {
        return this.solid;
    }
}
