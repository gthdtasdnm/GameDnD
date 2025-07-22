package state;

/**
 * Die Klasse {@code GameContext} verwaltet den aktuellen Spielzustand
 * und implementiert das State-Pattern als Singleton.
 *
 * <p>Sie stellt sicher, dass zur Laufzeit immer genau ein {@link GameState}
 * aktiv ist, und ermöglicht kontrollierte Zustandswechsel über {@code setState()}.</p>
 *
 * <p>Beim Zustandswechsel wird automatisch die {@code exit()}-Methode des vorherigen
 * Zustands sowie die {@code enter()}-Methode des neuen Zustands aufgerufen.</p>
 *
 * <p>Die Methode {@code update()} delegiert die Spiellogik an den aktuellen Zustand.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


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


