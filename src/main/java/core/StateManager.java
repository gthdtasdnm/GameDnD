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
    GameState gameState;
    Logger logger;

    public StateManager(Logger logger){
        this.logger = logger;
    }

    public void setGameState(GameState gameState) {
        if (this.gameState != null) {
            logger.info(this.gameState.getDescription() + " -> " + gameState.getDescription());
            this.gameState.exit();
        } else {
            logger.info("Initialer Zustand: " + gameState.getDescription());
        }

        this.gameState = gameState;
        gameState.enter();
    }


    public GameState getCurrentState() {
        return gameState;
    }
}
