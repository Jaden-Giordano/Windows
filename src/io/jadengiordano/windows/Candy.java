package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/5/2015.
 */
public abstract class Candy extends PickUp {

    protected Candy(World w) {
        super(w);

        this.transform.setScale(new Vector2(30, 30));
    }

    public Candy(World w, Vector3 pos) {
        super(w);

        this.transform.setPosition(pos);
        this.transform.setScale(new Vector2(30, 30));
    }

}
