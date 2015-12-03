package io.jadengiordano.windows;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Game {

    World world;

    public Game() {
        world = new World();
    }

    public void update(double dt) {
        world.update(dt);
    }

    public void draw() {
        world.draw();
    }

    public World getCurrentWorld() {
        return this.world;
    }

}
