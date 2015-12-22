package io.jadengiordano.windows.menuelements.mainmenu;

import io.jadengiordano.windows.*;
import io.jadengiordano.windows.menuelements.ColorButton;

/**
 * Created by Jaden on 12/22/2015.
 */
public class Play extends ColorButton {

    public Play(Menu menu) {
        super(menu, new Vector4(0, 1, 0, 1));

        this.transform.setScale(new Vector2(500, 100));
    }

    @Override
    public boolean use() {
        Windows.instance.getGame().setState(GameState.PLAY);

        return true;
    }
}
