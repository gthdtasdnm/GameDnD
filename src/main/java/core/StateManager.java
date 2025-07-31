package core;

import state.*;
import java.util.EnumMap;
import java.util.Map;

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
    private final Map<GameStateType, GameState> stateMap = new EnumMap<>(GameStateType.class);
    private GameState currentState;
    private final GameContext context;

    public StateManager(GameContext context) {
        logger.info("StateManager()");
        this.context = context;
        context.setStateManager(this); // <-- Frühzeitig setzen
        initStates();
    }

    private void initStates() {
        logger.info("initStates()");
        stateMap.put(GameStateType.MENU, new MenuState(context));
        stateMap.put(GameStateType.DIALOG, new DialogState(context));
        stateMap.put(GameStateType.EXPLORE, new ExploreState(context));
    }

    public void setGameState(GameStateType type) {
        logger.info("setGameState(): " + currentState + " to " + type);
        if (currentState != null) {
            currentState.exit();
        }
        currentState = stateMap.get(type);
        if (currentState != null) {
            currentState.enter();
        }
    }



    public GameState getCurrentState() {
        logger.info("Aktueller Zustand: " + currentState.getDescription());
        return currentState;
    }

    @Override
    public String toString() {
        logger.info("toString()");
        return "State Manager";
    }
}
