package io.jadengiordano.windows;

import io.jadengiordano.windows.objects.Player;
import io.jadengiordano.windows.objects.candy.BlueCandy;
import io.jadengiordano.windows.regs.ItemRegistry;
import io.jadengiordano.windows.regs.TileRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 11/29/2015.
 */
public class World {

    List<GameObject> objects;

    public World() {
        this.objects = new ArrayList<GameObject>();
        loadTiles();

        this.objects.add(new Player());
    }

    private void loadTiles() {
        int[] t = {10, 10,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, -1, -1, -1, 1, -1, -1, -1, -1, 0,
                0, -1, -1, -1, 1, -1, -1, -1, -1, 0,
                0, -1, -1, -1, 1, -1, -1, -1, -1, 0,
                0, 0, 0, 0, 0, 0, 3, 3, 3, 0,
                0, -1, -1, -1, -1, 0, -1, -1, -1, 0,
                0, -1, -1, -1, -1, 0, -1, -1, -1, 0,
                0, -1, -1, -1, -1, 5, -1, -1, -1, 0,
                0, -1, -1, -1, -1, 0, -1, -1, -1, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 2; i < t.length; i++) {
            int x = (i - 2) % t[0];
            int y = (int) Math.floor((i - 2) / t[1]);
            Tile tile = TileRegistry.getTile(t[i]);
            tile.transform.setPosition(new Vector3(x * 50, y * 50, 0));
            this.objects.add(tile);
        }

        BlueCandy bc = new BlueCandy(new Vector3(5 * 50 + 10, 2 * 50 + 10, 0));
        this.objects.add(bc);

        Item item = ItemRegistry.getItem(ItemRegistry.Items.GOLD_KEY.ordinal());
        item.transform.setPosition(new Vector3(8 * 50 + 15, 2 * 50 + 15, 0));
        this.objects.add(item);
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
