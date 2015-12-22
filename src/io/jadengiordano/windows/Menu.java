package io.jadengiordano.windows;

import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 12/22/2015.
 */
public abstract class Menu {

    protected List<MenuElement> elements;

    public Menu() {
        this.elements = new ArrayList<MenuElement>();

        Windows.instance.getMouseCallback().registerCallback(GLFW.GLFW_MOUSE_BUTTON_1, GLFW.GLFW_PRESS, new Runnable() {
            @Override
            public void run() {
                click();
            }
        });
    }

    public void update() {
        for (MenuElement i : this.elements) {
            i.update();
        }
    }

    public void draw() {
        for (MenuElement i : this.elements) {
            i.draw();
        }
    }

    private void click() {
        Vector2 mpos = Windows.instance.getMouseCallback().getMousePosition();
        BoundingBox mouse = new BoundingBox(new Vector3(mpos.x, mpos.y, 0), new Vector2(1, 1));
        for (MenuElement i : this.elements) {
            if (i instanceof Interactable) {
                BoundingBox el = new BoundingBox(i.transform.getPosition(), i.transform.getScale());
                if (mouse.overlaps(el)) {
                    ((Interactable) i).use();
                }
            }
        }
    }

}
