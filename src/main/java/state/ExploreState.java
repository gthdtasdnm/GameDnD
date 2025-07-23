package state;

import UI.GUI.ExploreScreen;
import core.StateManager;

/**
 * Der {@code ExploreState} repräsentiert den Spielzustand, in dem sich der Spieler frei durch die Welt bewegt.
 *
 * <p>Beim Betreten wird ein {@link UI.GUI.ExploreScreen} erzeugt, der die aktuelle Karte darstellt.
 *
 * <p>Während des Zustands werden Spielaktionen wie Bewegung, Begegnungen oder Interaktionen verarbeitet.</p>
 *
 * <p>Beim Verlassen wird der Bildschirm korrekt geschlossen und Eingabe-Listener entfernt.</p>
 *
 * <p>Dieser Zustand ist Teil des übergeordneten {@link core.GameManager} und nutzt {@link core.PlayerController}
 * zur Spielfigurensteuerung.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class ExploreState extends GameState implements GameEventListener {

    ExploreScreen screen;

    public ExploreState(StateManager stateManager) {
        super(stateManager);
        this.screen = new ExploreScreen(this);
    }

    @Override
    public void enter() {
        System.out.println("Betrete Erkundungsmodus");
        //mapScreen.getFrame().addKeyListener(new ArrowKeyListener(controller, mapScreen));
    }

    @Override
    public void update() {
        System.out.println("Spieler läuft durch die Welt");
        // z.B. auf Input reagieren
    }

    @Override
    public void exit() {
        System.out.println("Verlasse Erkundungsmodus");
    }

    @Override
    public String getDescription() {
        return "Explore State";
    }

    @Override
    public void onUiAction(String actionId) {

    }


}

