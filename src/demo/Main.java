package demo;

import core.StateManager;
import domain.dialog.DialogInstance;
import domain.dialog.DialogLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import state.GameState;
import state.MenuState;

public class Main {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Starte Spiel - #################################");
        StateManager stateManager = new StateManager(logger);
        GameState startState = new MenuState(stateManager);
        stateManager.setGameState(startState);
    }
}

