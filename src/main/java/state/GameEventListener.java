package state;

public interface GameEventListener {
    void onUiAction(String actionId);      // z. B. Button "start_game", "quit"

    // ggf. weitere Methoden: onMouseClick(), onPause(), onTimerTick() usw.
}
