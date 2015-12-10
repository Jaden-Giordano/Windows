package io.jadengiordano.windows;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 12/9/2015.
 */
public class GameSet {

    List<World> worlds;
    protected int current;

    public GameSet() {
        worlds = new ArrayList<World>();

        current = 0;
    }

    public void update() {
        this.getCurrentWorld().update();
    }

    public void draw() {
        this.getCurrentWorld().draw();
    }

    public World getCurrentWorld() {
        return this.worlds.get(this.current);
    }

    public void nextLevel() {
        if (worlds.size() - 1 >= current + 1) {
            current++;
        } else {
            System.out.println("...Game Over...");
        }
    }

}
