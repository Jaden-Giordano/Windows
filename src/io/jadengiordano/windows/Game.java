package io.jadengiordano.windows;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaden on 11/29/2015.
 */
public class Game {

    MainMenu mainMenu;

    List<GameSet> games;
    int current;

    private GameState state;

    public Game() {
        state = GameState.MENU;

        mainMenu = new MainMenu();

        games = new ArrayList<GameSet>();

        current = 0;

        games.add(new DefaultGameSet());
    }

    public void update() {
        switch (state) {
            case MENU: {
                mainMenu.update();
                break;
            }
            case PLAY: {
                getCurrentGameSet().update();
                break;
            }
            case PAUSE: {
                // IDK
                break;
            }
        }
    }

    public void draw() {
        switch (state) {
            case MENU: {
                mainMenu.draw();
                break;
            }
            case PLAY: {
                getCurrentGameSet().draw();
                break;
            }
            case PAUSE: {
                // IDK
                break;
            }
        }
    }

    public GameSet getCurrentGameSet() {
        return this.games.get(current);
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }
}
