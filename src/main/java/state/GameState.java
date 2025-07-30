package state;

import UI.Screen;
import core.StateManager;
import demo.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GameState {
    final Logger logger = LoggerFactory.getLogger(Main.class);
    protected final StateManager stateManager;
    protected Screen screen; // optional, wenn alle States GUI-basiert sind

    public GameState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public abstract void enter();
    public abstract void update();// Wird in diesem Zustand nicht verwendet. Reserviert für Game Loop.
    public abstract void exit();
    public abstract String getDescription();
}
