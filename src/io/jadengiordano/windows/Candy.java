package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/5/2015.
 */
public abstract class Candy extends PickUp {

    protected Candy() {
        super();

        this.transform.setScale(new Vector2(30, 30));
    }

    public Candy(Vector3 pos) {
        super();

        this.transform.setPosition(pos);
        this.transform.setScale(new Vector2(30, 30));
    }

}
