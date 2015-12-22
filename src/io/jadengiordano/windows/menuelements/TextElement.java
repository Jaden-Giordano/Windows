package io.jadengiordano.windows.menuelements;

import io.jadengiordano.windows.Menu;
import io.jadengiordano.windows.MenuElement;
import io.jadengiordano.windows.rockutil.GLText;

/**
 * Created by Jaden on 12/22/2015.
 */
public class TextElement extends MenuElement {

    GLText text;

    public TextElement(Menu menu, String text) {
        super(menu);

        //this.text = new GLText(text); TODO make text elements
    }

    @Override
    public void draw() {
        super.draw();

    }
}
