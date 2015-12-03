package io.jadengiordano.windows.objects;


import io.jadengiordano.windows.*;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Player extends GameObject {

    private float speed = 90.0f;

    private boolean[] keys;

    public Player() {
        super();

        this.keys = new boolean[4];

        registerInputs();

        this.transform.setScale(new Vector2(50, 50));
        this.color = new Vector4(.5f, .5f, 1, 1);
    }

    private void registerInputs() {
        Windows.instance.getKeyInputHandler().registerKeyCallback(GLFW.GLFW_KEY_D, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                keys[0] = true;
            }
        });
        Windows.instance.getKeyInputHandler().registerKeyCallback(GLFW.GLFW_KEY_D, GLFW.GLFW_RELEASE, new Runnable() {
            @Override
            public void run() {
                keys[0] = false;
            }
        });

        Windows.instance.getKeyInputHandler().registerKeyCallback(GLFW.GLFW_KEY_A, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                keys[1] = true;
            }
        });
        Windows.instance.getKeyInputHandler().registerKeyCallback(GLFW.GLFW_KEY_A, GLFW.GLFW_RELEASE, new Runnable() {
            @Override
            public void run() {
                keys[1] = false;
            }
        });

        Windows.instance.getKeyInputHandler().registerKeyCallback(GLFW.GLFW_KEY_W, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                keys[2] = true;
            }
        });
        Windows.instance.getKeyInputHandler().registerKeyCallback(GLFW.GLFW_KEY_W, GLFW.GLFW_RELEASE, new Runnable() {
            @Override
            public void run() {
                keys[2] = false;
            }
        });

        Windows.instance.getKeyInputHandler().registerKeyCallback(GLFW.GLFW_KEY_S, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                keys[3] = true;
            }
        });
        Windows.instance.getKeyInputHandler().registerKeyCallback(GLFW.GLFW_KEY_S, GLFW.GLFW_RELEASE, new Runnable() {
            @Override
            public void run() {
                keys[3] = false;
            }
        });
    }

    int lr = 0;
    int ud = 0;

    public void movementUpdate() {
        Vector3 pos = this.transform.getPosition();

        Vector3 dir = new Vector3(0, 0, 0);

        if (keys[0]) {
            dir.x += 1;
            lr = 1;
        } else {
            if (!keys[1] && lr == 1) {
                if ((Math.ceil(pos.x) % 50) != 0) {
                    this.transform.setPosition(new Vector3((float) ((Math.ceil(pos.x)) + (50 - (Math.ceil(pos.x) % 50))), pos.y, 0));
                } else {
                    lr = 0;
                }
            }
        }
        if (keys[1]) {
            dir.x += -1;
            lr = -1;
        } else {
            if (!keys[0] && lr == -1) {
                if ((Math.ceil(pos.x) % 50) != 0) {
                    this.transform.setPosition(new Vector3((float) ((Math.ceil(pos.x)) - ((Math.ceil(pos.x) % 50))), pos.y, 0));
                } else {
                    lr = 0;
                }
            }
        }
        if (keys[2]) {
            dir.y += -1;
            ud = -1;
        } else {
            if (!keys[3] && ud == -1) {
                if ((Math.ceil(pos.y) % 50) != 0) {
                    this.transform.setPosition(new Vector3(pos.x, (float) ((Math.ceil(pos.y)) - ((Math.ceil(pos.y) % 50))), 0));
                } else {
                    ud = 0;
                }
            }
        }
        if (keys[3]) {
            dir.y += 1;
            ud = 1;
        } else {
            if (!keys[2] && ud == 1) {
                if ((Math.ceil(pos.y) % 50) != 0) {
                    this.transform.setPosition(new Vector3(pos.x, (float) ((Math.ceil(pos.y)) + (50 - (Math.ceil(pos.y) % 50))), 0));
                } else {
                    ud = 0;
                }
            }
        }

        move(dir);
    }

    public boolean canMove(Vector3 dir) { // TODO Make hor./vert. independant
        List<Tile> tiles = new ArrayList<Tile>();
        for (GameObject i : Windows.instance.getGame().getCurrentWorld().getObjects()) {
            if (i instanceof Tile)
                tiles.add((Tile) i);
        }
        Vector3 p = this.transform.getPosition();
        Vector3 npos = new Vector3((float) Math.floor(p.x / 50) + dir.x, (float) Math.floor(p.y / 50) + dir.y, 0);

        for (Tile i : tiles) {
            if (i.transform.getPosition().div(50).equals(npos)) {
                //System.out.println("------------------------------");
                //System.out.println("| Direction: "+dir.x+", "+dir.y+", "+dir.z);
                //System.out.println("| Tile: "+i.transform.getPosition().x + ", " + i.transform.getPosition().y + ", " + i.transform.getPosition().z + " : " + i.isSolid());
                if (i.isSolid())
                    return false;
            }
        }

        return true;
    }

    public void move(Vector3 dir) {
        Vector3 pos = this.transform.getPosition();
        if (canMove(dir))
            this.transform.setPosition(pos.add(dir.mul(speed * (float) Timer.deltaTime)));
    }

    public void update(double dt) {
        super.update(dt);

        movementUpdate();
    }

}
