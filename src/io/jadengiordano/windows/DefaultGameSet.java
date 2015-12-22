package io.jadengiordano.windows;

import io.jadengiordano.windows.worlds.DefaultWorld;
import io.jadengiordano.windows.worlds.WorldTwo;

/**
 * Created by Jaden on 12/9/2015.
 */
public class DefaultGameSet extends GameSet {

    public DefaultGameSet() {
        super();
        this.worlds.add(new DefaultWorld(this));
        this.worlds.add(new WorldTwo(this));
    }

}
