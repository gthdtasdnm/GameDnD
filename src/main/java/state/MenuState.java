package state;

import UI.GUI.MenuScreen;
import core.StateManager;

public class MenuState extends GameState implements GameEventListener {
    MenuScreen screen;

    public MenuState(StateManager stateManager) {
        super(stateManager);
        this.screen = new MenuScreen(this); // konkret für diesen State
    }

    @Override
    public void enter() {
        System.out.println("Menu geöffnet");
        screen.createScreen();
    }

    @Override
    public void update() {

        System.out.println("Menu läuft");
    }

    @Override
    public void exit() {
        System.out.println("Menu geschlossen");
        screen.closeScreen();
    }

    @Override
    public String getDescription() {
        return "Fight State";
    }

    @Override
    public void onUiAction(String actionId) {
        if (actionId.equals("start_game")) {
            System.out.println("start gedrückt");
            stateManager.setGameState(new DialogState(stateManager));
        } else if (actionId.equals("exit_game")) {
            System.exit(0);
        }
    }

}
