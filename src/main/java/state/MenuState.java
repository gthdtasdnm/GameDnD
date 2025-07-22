package state;

import UI.GUI.MenuScreen;

public class MenuState implements GameState {
    MenuScreen menuScreen;

    public MenuState() {
        menuScreen = new MenuScreen();
    }

    @Override
    public void enter() {
        System.out.println("Menu geöffnet");
        menuScreen.createScreen();
    }

    @Override
    public void update() {
        System.out.println("Menu läuft");
    }

    @Override
    public void exit() {
        System.out.println("Menu geschlossen");
        menuScreen.closeScreen();
    }

    @Override
    public String getDescription() {
        return "Fight State";
    }
}
