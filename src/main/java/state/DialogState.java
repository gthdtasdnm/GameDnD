package state;

import domain.dialog.DialogInstance;
import UI.GUI.DialogScreen;
import core.GameManager;

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


public class DialogState implements GameState{
    DialogScreen dialogScreen = new DialogScreen();

    public DialogState(GameManager gameManager, DialogInstance dialog) {

    }

    @Override
    public void enter() {
        System.out.println("Starte Dialog");
        dialogScreen.createScreen();
    }

    @Override
    public void update() {
        System.out.println("Spieler unterhält sich");
        // z.B. auf Input reagieren
    }

    @Override
    public void exit() {
        System.out.println("Verlasse Dialog");
        dialogScreen.closeScreen();
    }
}

