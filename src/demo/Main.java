package demo;

import core.GameContext;
import core.StateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import state.GameState;
import state.MenuState;

public class Main {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
    logger.info("main()");
        GameContext context = new GameContext();

        StateManager stateManager = new StateManager(context);
        context.setStateManager(stateManager);

        GameState startState = new MenuState(context);
        stateManager.setGameState(startState);
    }
}


