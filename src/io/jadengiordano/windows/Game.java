package io.jadengiordano.windows;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Game {

    World world;

    List<GameSet> games;
    int current;

    public Game() {
        games = new ArrayList<GameSet>();

        current = 0;

        games.add(new DefaultGameSet());
    }

    public void update() {
        getCurrentGameSet().update();
    }

    public void draw() {
        getCurrentGameSet().draw();
    }

    public GameSet getCurrentGameSet() {
        return this.games.get(current);
    }

}
