package UI.Input;

import UI.GUI.MapScreen;
import core.PlayerController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Die Klasse {@code ArrowKeyListener} verarbeitet Tastatureingaben für die Spielerbewegung
 * im Erkundungsmodus.
 *
 * <p>Sie erweitert {@link java.awt.event.KeyAdapter} und reagiert auf die Tasten {@code W}, {@code A}, {@code S}, {@code D},
 * um den Spieler in die entsprechende Richtung zu bewegen.</p>
 *
 * <p>Nach jeder Bewegung wird die Karte über {@link UI.GUI.MapScreen#renderMap()} neu gezeichnet,
 * um die aktualisierte Position sichtbar zu machen.</p>
 *
 * <p>Wird typischerweise im {@link state.ExploreState} beim Aufruf des {@code MapScreen} registriert.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class ArrowKeyListener extends KeyAdapter {
    private final PlayerController controller;
    private final MapScreen mapScreen;

    public ArrowKeyListener(PlayerController controller, MapScreen mapScreen) {
        this.controller = controller;
        this.mapScreen = mapScreen;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> controller.movePlayer(0, -1);
            case KeyEvent.VK_S -> controller.movePlayer(0, 1);
            case KeyEvent.VK_A -> controller.movePlayer(-1, 0);
            case KeyEvent.VK_D -> controller.movePlayer(1, 0);
        }
        mapScreen.renderMap(); // damit die neue Position angezeigt wird
    }
}


