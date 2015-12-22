package io.jadengiordano.windows.objects;

import io.jadengiordano.windows.*;

/**
 * Created by Jaden on 12/6/2015.
 */
public class Lever extends GameObject implements Interactable {

    Attachable attached;

    public Lever(World w, Attachable attached) {
        super(w);

        this.attached = attached;

        this.color = new Vector4(0, 0, 0, 1);
        this.transform.setScale(10, 5);
    }

    @Override
    public boolean use() {
        attached.setState(!attached.getState());
        return true;
    }

    @Override
    public void draw() {
        super.draw();
    }
}
