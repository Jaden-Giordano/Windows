package io.jadengiordano.windows.worlds;

import io.jadengiordano.windows.*;
import io.jadengiordano.windows.objects.Lever;
import io.jadengiordano.windows.objects.Player;
import io.jadengiordano.windows.objects.candy.BlueCandy;
import io.jadengiordano.windows.regs.ItemRegistry;
import io.jadengiordano.windows.regs.TileRegistry;

/**
 * Created by Jaden on 12/9/2015.
 */
public class DefaultWorld extends World {

    public DefaultWorld(GameSet g) {
        super(g);

        loadTiles();

        Player player = new Player(this);
        player.transform.setPosition(new Vector3(50 + 5, 50 + 5, 0));
        this.objects.add(player);
    }

    private void loadTiles() {
        int[] t = {10, 10,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, -1, -1, -1, 1, -1, -1, -1, -1, 0,
                0, -1, -1, -1, 1, -1, -1, -1, -1, 0,
                0, -1, -1, -1, 1, -1, -1, -1, -1, 0,
                0, 0, 0, 0, 0, 0, 3, 3, 3, 0,
                0, 9, 0, -1, -1, 0, -1, -1, -1, 0,
                0, -1, 0, -1, -1, 0, -1, -1, -1, 0,
                0, -1, 5, -1, -1, 5, -1, -1, -1, 0,
                0, -1, 0, -1, -1, 0, -1, -1, -1, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 2; i < t.length; i++) {
            int x = (i - 2) % t[0];
            int y = (int) Math.floor((i - 2) / t[1]);
            Tile tile = TileRegistry.getTile(this, t[i]);
            tile.transform.setPosition(new Vector3(x * 50, y * 50, 0));
            this.objects.add(tile);
        }

        BlueCandy bc = new BlueCandy(this, new Vector3(5 * 50 + 10, 2 * 50 + 10, 0));
        this.objects.add(bc);

        Item item = ItemRegistry.getItem(this, ItemRegistry.Items.GOLD_KEY.ordinal());
        item.transform.setPosition(new Vector3(8 * 50 + 15, 2 * 50 + 15, 0));
        this.objects.add(item);

        Door o = null;
        for (GameObject i : this.getObjects()) {
            Vector3 pos = i.transform.getPosition();
            if (pos.x == 2 * 50 && pos.y == 7 * 50)
                o = (Door) i;
        }
        if (o != null) {
            Lever lever = new Lever(this, o);
            lever.transform.setPosition(3 * 50 + 20, 5 * 50, 0);
            this.objects.add(lever);
        }
    }

}
