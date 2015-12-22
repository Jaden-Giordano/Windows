package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/22/2015.
 */
public abstract class MenuElement {

    Menu menu;

    public Transform transform;

    public MenuElement(Menu menu) {
        this.menu = menu;

        this.transform = new Transform();
    }

    public void update() {

    }

    public void draw() {

    }

}
