package io.jadengiordano.windows;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 11/29/2015.
 */
public class World {

    List<GameObject> objects;

    public World() {
        this.objects = new ArrayList<GameObject>();
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public List<PickUp> getPickUps() {
        List<PickUp> pickUps = new ArrayList<PickUp>();
        for (GameObject i : this.objects) {
            if (i instanceof PickUp)
                pickUps.add((PickUp) i);
        }
        return pickUps;
    }

    public void update() {
        List<GameObject> rmv = new ArrayList<GameObject>();
        for (GameObject i : this.objects) {
            i.update();
            if (i instanceof PickUp) {
                if (((PickUp) i).remove)
                    rmv.add(i);
            }
        }
        for (GameObject i : rmv) {
            this.objects.remove(i);
        }
    }

    public void draw() {
        for (GameObject i : this.objects) {
            i.draw();
        }
    }

}
