package io.jadengiordano.windows;

import io.jadengiordano.windows.objects.Player;

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
        int[] t = {5, 5, -1, -1, -1, -1, -1, 0, 0, -1, 0, 0, 0, 0, -1, 0, 0, 0, 0, -1, 0, 0, -1, -1, -1, -1, -1};

        for (int i = 2; i < t.length; i++) {
            int x = (i - 2) % t[0];
            int y = (int) Math.floor((i - 2) / t[1]);
            Tile tile = TileRegistry.getTile(t[i]);
            tile.transform.setPosition(new Vector3(x * 50, y * 50, 0));
            this.objects.add(tile);
        }
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public void update(double dt) {
        for (GameObject i : this.objects) {
            i.update(dt);
        }
    }

    public void draw() {
        for (GameObject i : this.objects) {
            i.draw();
        }
    }

}
