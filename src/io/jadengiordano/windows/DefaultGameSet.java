package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/9/2015.
 */
public class DefaultGameSet extends GameSet {

    public DefaultGameSet() {
        super();
        this.worlds.add(new DefaultWorld());
        this.worlds.add(new DefaultWorld());
    }

}
