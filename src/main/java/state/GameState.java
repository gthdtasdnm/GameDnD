package state;

import UI.GUI.Screen;
import core.StateManager;

public abstract class GameState {
    protected final StateManager stateManager;
    protected Screen screen; // optional, wenn alle States GUI-basiert sind

    public GameState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public abstract void enter();
    public abstract void update();
    public abstract void exit();
    public abstract String getDescription();
}
