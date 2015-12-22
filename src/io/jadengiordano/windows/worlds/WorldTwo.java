package io.jadengiordano.windows.worlds;

import io.jadengiordano.windows.*;
import io.jadengiordano.windows.objects.Lever;
import io.jadengiordano.windows.objects.Player;
import io.jadengiordano.windows.objects.candy.BlueCandy;
import io.jadengiordano.windows.objects.candy.GreenCandy;
import io.jadengiordano.windows.regs.ItemRegistry;
import io.jadengiordano.windows.regs.TileRegistry;

/**
 * Created by Jaden on 12/9/2015.
 */
public class WorldTwo extends World {

    public WorldTwo(GameSet g) {
        super(g);

        loadTiles();

        Player p = new Player(this);
        p.transform.setPosition(new Vector3(1 * 50 + 5, 5 * 50 + 5, 0));
        p.setColour(Color.RED);
        this.objects.add(p);
    }

    private void loadTiles() {
        int[] t = {10, 10,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, -1, 3, -1, -1, -1, -1, -1, -1, 0,
                0, -1, 3, -1, -1, -1, -1, -1, -1, 0,
                0, 0, 0, -1, -1, -1, -1, -1, -1, 0,
                0, -1, -1, -1, -1, 0, 1, 1, 0, 0,
                0, -1, -1, -1, -1, 2, -1, -1, -1, 0,
                0, -1, -1, -1, -1, 0, 0, 0, 0, 0,
                0, 2, 2, 0, 5, 0, -1, -1, 9, 0,
                0, -1, -1, 0, -1, 5, -1, -1, 9, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 2; i < t.length; i++) {
            int x = (i - 2) % t[0];
            int y = (int) Math.floor((i - 2) / t[1]);
            Tile tile = TileRegistry.getTile(this, t[i]);
            tile.transform.setPosition(new Vector3(x * 50, y * 50, 0));
            this.objects.add(tile);
        }

        // Create Lever
        // Find door that it is linked to TODO make this easier
        Door exitdoor = null;
        // Search for door created at specific tile
        for (GameObject i : this.getObjects()) {
            Vector3 pos = i.transform.getPosition();
            if (pos.x == 5 * 50 && pos.y == 8 * 50)
                exitdoor = (Door) i;
        }
        if (exitdoor != null) {
            Lever l = new Lever(this, exitdoor);
            l.transform.setPosition(1 * 50 + 20, 1 * 50, 0);
            this.objects.add(l);
        }

        Item key = ItemRegistry.getItem(this, ItemRegistry.Items.GOLD_KEY.ordinal()); // TODO make it so ordinal doesnt need to be used
        key.transform.setPosition(1 * 50 + 15, 8 * 50 + 15, 0);
        this.objects.add(key);

        GreenCandy greenCandy = new GreenCandy(this, new Vector3(8 * 50 + 10, 5 * 50 + 10, 0));
        this.objects.add(greenCandy);

        BlueCandy blueCandy = new BlueCandy(this, new Vector3(4 * 50 + 10, 8 * 50 + 10, 0));
        this.objects.add(blueCandy);


    }

}
