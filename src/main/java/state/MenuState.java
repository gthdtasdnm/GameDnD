package state;

import UI.MenuScreen;
import core.GameContext;
import core.factory.ScreenFactory;
import domain.dialog.DialogInstance;
import domain.dialog.DialogLine;
import domain.dialog.Information;

import java.util.ArrayList;
import java.util.List;

public class MenuState extends GameState implements GameEventListener {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MenuState.class);
    MenuScreen screen;

    public MenuState(GameContext context) {
        super(context);
        ScreenFactory factory = context.getScreenFactory();
        this.screen = factory.createMenuScreen(this);
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
    logger.info("getDescription()");        return "Menu State";
    }

    @Override
    public void onUiAction(String actionId) {
    logger.info("MenuState.onUiAction(): " + actionId);
        switch (actionId) {
            case "start_game" -> {
                List<DialogInstance> dialogs = context.getDialogRepository().getDialogsByNpc("Diego");
                stateManager.setGameState(new DialogState(context, dialogs));
            }
            case "exit_game" -> System.exit(0);
            default -> logger.warn("Unbekannte UI-Aktion: " + actionId);
        }
    }


}
