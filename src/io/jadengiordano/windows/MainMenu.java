package io.jadengiordano.windows;

import io.jadengiordano.windows.menuelements.mainmenu.Play;

/**
 * Created by Jaden on 12/22/2015.
 */
public class MainMenu extends Menu {

    public MainMenu() {
        super();

        Vector2 center = new Vector2(Windows.WIDTH / 2, Windows.HEIGHT / 2);

        Play play = new Play(this);
        Vector2 scale = play.transform.getScale();
        play.transform.setPosition(center.x - (scale.x / 2), center.y - (scale.y / 2), 0);
        this.elements.add(play);
    }
}
