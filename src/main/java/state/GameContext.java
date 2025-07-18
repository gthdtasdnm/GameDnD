package state;

public class GameContext {
    private static GameContext instance;
    private GameState currentState;

    public GameContext() {}

    public static GameContext getInstance() {
        if (instance == null) {
            instance = new GameContext();
        }
        return instance;
    }

    public void setState(GameState newState) {
        if (currentState != null) currentState.exit();
        currentState = newState;
        if (currentState != null) currentState.enter();
    }

    public void update() {
        if (currentState != null) currentState.update();
    }
}


