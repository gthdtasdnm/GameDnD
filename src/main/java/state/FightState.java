package state;

import UI.GUI.DialogScreen;
import UI.GUI.FightScreen;
import core.StateManager;
import domain.character.Enemy;
import domain.character.PlayerCharacter;
import core.GameManager;

/**
 * Der {@code FightState} repräsentiert den Spielzustand, in dem ein Kampf
 * zwischen dem Spieler und einem Gegner stattfindet.
 *
 * <p>Beim Betreten wird ein {@link UI.GUI.FightScreen} erzeugt, der den Kampf visuell darstellt.
 * Während {@code update()} können z. B. Angriffe, Rundenfortschritt oder Aktionen verarbeitet werden.</p>
 *
 * <p>Nach Beendigung des Kampfes wird der Bildschirm korrekt geschlossen.</p>
 *
 * <p>Dieser Zustand ist Teil der State-Logik des {@link core.GameManager}
 * und interagiert mit {@link domain.character.PlayerCharacter} und {@link domain.character.Enemy}.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class FightState extends GameState implements GameEventListener {

    FightScreen screen;

    public FightState(StateManager stateManager) {
        super(stateManager);
        this.screen = new FightScreen(this);
    }

    @Override
    public void enter() {
        System.out.println("Kampf beginnt!");
        screen.createScreen();
    }

    @Override
    public void update() {
        System.out.println("Kampf läuft...");
    }

    @Override
    public void exit() {
        System.out.println("Kampf vorbei.");
        screen.closeScreen();
    }

    @Override
    public String getDescription() {
        return "Fight State";
    }

    @Override
    public void onUiAction(String actionId) {

    }


}

