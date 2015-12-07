package io.jadengiordano.windows.objects;

import io.jadengiordano.windows.*;
import io.jadengiordano.windows.items.Key;
import io.jadengiordano.windows.tiles.GlassTile;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Player extends GameObject {

    private float speed = 90.0f;

    private Color colour;

    private boolean[] keys;

    private Inventory inventory;

    public Player() {
        super();

        this.keys = new boolean[4];

        registerInputs();

        this.transform.setScale(new Vector2(40, 40));
        this.color = new Vector4(.5f, .5f, 1, 1);
        this.colour = Color.RED;

        this.transform.setPosition(new Vector3(50 + 5, 50 + 5, 0));

        this.inventory = new Inventory(4);
    }

    private void registerInputs() {
        Windows.instance.getKeyInputHandler().registerCallback(GLFW.GLFW_KEY_D, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                keys[0] = true;
            }
        });
        Windows.instance.getKeyInputHandler().registerCallback(GLFW.GLFW_KEY_D, GLFW.GLFW_RELEASE, new Runnable() {
            @Override
            public void run() {
                keys[0] = false;
            }
        });

        Windows.instance.getKeyInputHandler().registerCallback(GLFW.GLFW_KEY_A, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                keys[1] = true;
            }
        });
        Windows.instance.getKeyInputHandler().registerCallback(GLFW.GLFW_KEY_A, GLFW.GLFW_RELEASE, new Runnable() {
            @Override
            public void run() {
                keys[1] = false;
            }
        });

        Windows.instance.getKeyInputHandler().registerCallback(GLFW.GLFW_KEY_W, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                keys[2] = true;
            }
        });
        Windows.instance.getKeyInputHandler().registerCallback(GLFW.GLFW_KEY_W, GLFW.GLFW_RELEASE, new Runnable() {
            @Override
            public void run() {
                keys[2] = false;
            }
        });

        Windows.instance.getKeyInputHandler().registerCallback(GLFW.GLFW_KEY_S, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                keys[3] = true;
            }
        });
        Windows.instance.getKeyInputHandler().registerCallback(GLFW.GLFW_KEY_S, GLFW.GLFW_RELEASE, new Runnable() {
            @Override
            public void run() {
                keys[3] = false;
            }
        });

        Windows.instance.getMouseCallback().registerCallback(GLFW.GLFW_MOUSE_BUTTON_1, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                use();
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
                    //this.transform.setPosition(new Vector3((float) ((Math.ceil(pos.x)) + (50 - (Math.ceil(pos.x) % 50))), pos.y, 0));
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
                    //this.transform.setPosition(new Vector3((float) ((Math.ceil(pos.x)) - ((Math.ceil(pos.x) % 50))), pos.y, 0));
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
                    //this.transform.setPosition(new Vector3(pos.x, (float) ((Math.ceil(pos.y)) - ((Math.ceil(pos.y) % 50))), 0));
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
                    //this.transform.setPosition(new Vector3(pos.x, (float) ((Math.ceil(pos.y)) + (50 - (Math.ceil(pos.y) % 50))), 0));
                } else {
                    ud = 0;
                }
            }
        }

        move(dir);
    }

    public Vector3 possibleMove(Vector3 dir) {
        Vector3 p = this.transform.getPosition();
        BoundingBox top = new BoundingBox(new Vector3(p.x + 1, p.y - 3f, 0f), new Vector2(38, 6));
        BoundingBox left = new BoundingBox(new Vector3(p.x - 3f, p.y + 1, 0f), new Vector2(6, 38));
        BoundingBox right = new BoundingBox(new Vector3(p.x + 37f, p.y + 1, 0f), new Vector2(6, 38));
        BoundingBox bottom = new BoundingBox(new Vector3(p.x + 1, p.y + 37f, 0f), new Vector2(38, 6));

        List<Tile> tiles = new ArrayList<Tile>();
        for (GameObject i : Windows.instance.getGame().getCurrentWorld().getObjects()) {
            if (i instanceof Tile)
                tiles.add((Tile) i);
        }

        //System.out.println(p.x + ", " + p.y);

        for (Tile i : tiles) {
            if (i.isSolid()) {
                BoundingBox it = new BoundingBox(i.transform.getPosition(), i.transform.getScale());
                if (top.overlaps(it) && dir.y < 0) {
                    //System.out.println("TOP: " + it.pos.x + ", " + it.pos.y + " : " + String.valueOf(dir.x * 50 + p.x) + ", " + String.valueOf(dir.y * 50 + p.y));
                    //System.out.println("---------------------");
                    if (!(i instanceof GlassTile)) {
                        dir.y = 0;
                        this.transform.getPosition().y = it.pos.y + it.size.y;
                    } else {
                        if (((GlassTile) i).getColour().ordinal() != this.colour.ordinal()) {
                            dir.y = 0;
                            this.transform.getPosition().y = it.pos.y + it.size.y;
                        } else {
                            ((GlassTile) i).movedThrough(this);
                        }
                    }
                }
                if (bottom.overlaps(it) && dir.y > 0) {
                    //System.out.println("BOTTOM: " + it.pos.x + ", " + it.pos.y + " : " + String.valueOf(dir.x * 50 + p.x) + ", " + String.valueOf(dir.y * 50 + p.y));
                    //System.out.println("---------------------");
                    if (!(i instanceof GlassTile)) {
                        dir.y = 0;
                        this.transform.getPosition().y = it.pos.y - this.transform.getScale().y;
                    } else {
                        if (((GlassTile) i).getColour().ordinal() != this.colour.ordinal()) {
                            dir.y = 0;
                            this.transform.getPosition().y = it.pos.y - this.transform.getScale().y;
                        } else {
                            ((GlassTile) i).movedThrough(this);
                        }
                    }
                }
                if (left.overlaps(it) && dir.x < 0) {
                    //System.out.println("LEFT: " + it.pos.x + ", " + it.pos.y + " : " + String.valueOf(dir.x * 50 + p.x) + ", " + String.valueOf(dir.y * 50 + p.y));
                    //System.out.println(left.pos.x + ", " + left.pos.y);
                    //System.out.println("---------------------");
                    if (!(i instanceof GlassTile)) {
                        dir.x = 0;
                        this.transform.getPosition().x = it.pos.x + it.size.x;
                    } else {
                        if (((GlassTile) i).getColour().ordinal() != this.colour.ordinal()) {
                            dir.x = 0;
                            this.transform.getPosition().x = it.pos.x + it.size.x;
                        } else {
                            ((GlassTile) i).movedThrough(this);
                        }
                    }
                }
                if (right.overlaps(it) && dir.x > 0) {
                    //System.out.println("RIGHT: " + it.pos.x + ", " + it.pos.y + " : " + dir.x * 50 + p.x + ", " + String.valueOf(dir.x * 50 + p.x) + ", " + String.valueOf(dir.y * 50 + p.y));
                    //System.out.println("---------------------");
                    if (!(i instanceof GlassTile)) {
                        dir.x = 0;
                        this.transform.getPosition().x = it.pos.x - this.transform.getScale().x;
                    }
                    else {
                        if (((GlassTile) i).getColour().ordinal() != this.colour.ordinal()) {
                            dir.x = 0;
                            this.transform.getPosition().x = it.pos.x - this.transform.getScale().x;
                        } else {
                            ((GlassTile) i).movedThrough(this);
                        }
                    }
                }
            }
        }

        return dir;
    }

    public void move(Vector3 dir) {
        Vector3 pos = this.transform.getPosition();
        this.transform.setPosition(pos.add(possibleMove(dir).mul(speed * (float) Timer.deltaTime)));
    }

    private void pickupdate() {
        BoundingBox pl = new BoundingBox(this.transform.getPosition(), this.transform.getScale());
        for (PickUp i : Windows.instance.getGame().getCurrentWorld().getPickUps()) {
            if (!i.remove) {
                BoundingBox pk = new BoundingBox(i.transform.getPosition(), i.transform.getScale());
                if (pk.overlaps(pl)) {
                    i.pickUp(this);
                }
            }
        }
    }

    public void update() {
        super.update();

        movementUpdate();

        pickupdate();
/*
        for (int i = 0; i < this.getInventory().size(); i++) {
            Item item;
            if ((item = this.inventory.getItemByIndex(i)) != null) {
                System.out.println("Slot "+i+": "+item.getID());
            }
            else {
                System.out.println("Slot "+i+": null");
            }
        }
*/
    }

    public void use() {
        if (inventory.getItemByIndex(0) != null) {
            Vector2 mp = Windows.instance.getMouseCallback().getMousePosition();

            for (GameObject i : Windows.instance.getGame().getCurrentWorld().getObjects()) {
                if (i instanceof Door) { // TODO make interactable class that door extends from (has use function)
                    Vector3 pos = i.transform.getPosition();
                    Vector2 sc = i.transform.getScale();


                    if (mp.x >= pos.x && mp.x <= pos.x + sc.x && mp.y >= pos.y && mp.y <= pos.y + sc.y
                            /*&& Math.sqrt(Math.pow(pos.x-this.transform.getPosition().x, 2)+Math.pow(pos.y-this.transform.getPosition().y, 2)) < 3*50*/) { // TODO Check is blocks blocking view
                        System.out.println("click");
                        if (inventory.getItemByIndex(0) instanceof Key) { // TODO make all items have use function
                            ((Key) inventory.getItemByIndex(0)).use((Door) i);
                        }
                    }
                }
            }
        }
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public Inventory getInventory() {
        return inventory;
    }

}
