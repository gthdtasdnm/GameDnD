package core;

import demo.Main;
import state.GameState;
import state.MenuState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Der {@code StateManager} verwaltet den aktuellen Spielzustand.
 *
 * <p>Geplant ist die zentrale Koordination von Zustandswechseln
 * zwischen Erkundung, Kampf, Dialog und Menüs.</p>
 *
 * <p>Er soll künftig als Bindeglied zwischen Eingaben, Logik und Darstellung fungieren.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class StateManager {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StateManager.class);
    GameState gameState;

    public StateManager(GameContext context){
    }

    public void setGameState(GameState gameState) {
    logger.info("setGameState()");        if (this.gameState != null) {
            logger.info(this.gameState.getDescription() + " -> " + gameState.getDescription());
            this.gameState.exit();
        } else {
            logger.info("Initialer Zustand: " + gameState.getDescription());
        }

        this.gameState = gameState;
        gameState.enter();
    }


    public GameState getCurrentState() {
    logger.info("getCurrentState()");        logger.info("Aktueller Zustand: " + gameState.getDescription());
        return gameState;
    }

    @Override
    public String toString() {
    logger.info("toString()");        return "State Manager";
    }
}
