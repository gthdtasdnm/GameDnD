package demo;

import core.GameContext;
import core.StateManager;
import core.factory.DefaultScreenFactory;
import core.factory.ScreenFactory;
import data.DialogRepository;
import state.GameState;
import state.MenuState;

public class Main {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
    logger.info("main()");
    GameContext context = new GameContext();

    StateManager stateManager = new StateManager(context);
    context.setStateManager(stateManager);

    ScreenFactory screenFactory = new DefaultScreenFactory();
    context.setScreenFactory(screenFactory);

    context.setDialogRepository(new DialogRepository());

    GameState startState = new MenuState(context);
    stateManager.setGameState(startState);
    }
}


