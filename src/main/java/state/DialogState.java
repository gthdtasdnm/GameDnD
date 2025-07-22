package state;

import domain.dialog.DialogInstance;
import UI.GUI.DialogScreen;
import core.GameManager;

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

