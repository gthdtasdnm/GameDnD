package state;

import UI.MenuScreen;
import core.GameContext;
import core.StateManager;
import core.factory.ScreenFactory;
import domain.dialog.DialogInstance;
import java.util.List;

public class MenuState extends GameState implements GameEventListener {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MenuState.class);
    MenuScreen screen;
    StateManager stateManager;

    public MenuState(GameContext context) {
        super(context);
        ScreenFactory factory = context.getScreenFactory();
        this.screen = factory.createMenuScreen(this);
        this.stateManager = context.getStateManager();
        logger.info("MenuState()");
    }

    @Override
    public void enter() {
        logger.info("enter()");
        screen.createScreen();
    }

    @Override
    public void update() {
        logger.info("update()");
    }

    @Override
    public void exit() {
        logger.info("exit()");
        screen.closeScreen();
    }

    @Override
    public String getDescription() {
        logger.info("getDescription()");
        return "Menu State";
    }

    @Override
    public void onUiAction(String actionId) {
        logger.info("MenuState.onUiAction(): " + actionId);
        switch (actionId) {
            case "start_game" -> {

                stateManager.setGameState(GameStateType.DIALOG);
            }
            case "exit_game" -> System.exit(0);
            default -> logger.warn("Unbekannte UI-Aktion: " + actionId);
        }
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
