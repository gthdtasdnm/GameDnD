package state;

import UI.Screen;
import core.GameContext;
import core.StateManager;

public abstract class GameState {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GameState.class);
    protected final StateManager stateManager;
    protected GameContext context;
    protected Screen screen; // optional, wenn alle States GUI-basiert sind

    public GameState(GameContext context) {
        logger.info("GameState()");
        this.context = context;
        this.stateManager = context.getStateManager();
    }

    public abstract void enter();
    public abstract void update();// Wird in diesem Zustand nicht verwendet. Reserviert für Game Loop.
    public abstract void exit();
    public abstract String getDescription();
}
