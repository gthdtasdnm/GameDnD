package state;

import core.StateManager;
import UI.GUI.DialogScreen;

/**
 * Der {@code DialogState} repräsentiert den Spielzustand, in dem sich der Spieler
 * in einem aktiven Dialog mit einem NPC befindet.
 *
 * <p>Beim Betreten des Zustands wird ein {@link UI.GUI.DialogScreen} erstellt,
 * der den Dialog visuell darstellt. Während {@code update()} können z. B.
 * Eingaben verarbeitet oder Dialogoptionen ausgewählt werden.</p>
 *
 * <p>Beim Verlassen des Zustands wird der Dialogbildschirm geschlossen.</p>
 *
 * <p>Dieser Zustand ist Teil der State-Logik im {@link core.GameManager}.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class DialogState extends GameState implements GameEventListener{
    DialogScreen screen;

    public DialogState(StateManager stateManager) {
        super(stateManager);
        this.screen = new DialogScreen(this);
    }

    @Override
    public void enter() {
        System.out.println("Starte Dialog");
        screen.createScreen();
    }

    @Override
    public void update() {
        System.out.println("Spieler unterhält sich");
        // z.B. auf Input reagieren
    }

    @Override
    public void exit() {
        System.out.println("Verlasse Dialog");
        screen.closeScreen();
    }

    @Override
    public String getDescription() {
        return "Dialog State";
    }

    @Override
    public void onUiAction(String actionId) {

    }

}

