package core;

import state.GameState;
import state.MenuState;

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

    public StateManager(){
        setGameState(new MenuState(this));
    }

    public void setGameState(GameState gameState){
        if(this.gameState != null){
            this.gameState.exit();
        }
        this.gameState = gameState;
        gameState.enter();
    }

    public GameState getCurrentState() {
        return gameState;
    }
}
