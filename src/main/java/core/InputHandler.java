package core;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Reagiert auf Tastendrücke und leitet sie weiter z. B. an den PlayerController.
 * Verwendet für Echtzeit-Eingaben im JFrame ohne Blockierung.
 *
 * Beispiel: Steuerung mit WASD oder Pfeiltasten.
 */
public class InputHandler extends KeyAdapter {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(InputHandler.class);

    private final InputCallback callback;

    public interface InputCallback {
        void onInput(String key);
    }

    public InputHandler(InputCallback callback) {
        this.callback = callback;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    logger.info("keyPressed()");        String keyText = KeyEvent.getKeyText(e.getKeyCode()).toUpperCase();
        callback.onInput(keyText);
    }
}
