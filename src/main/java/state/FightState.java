package state;

import UI.GUI.FightScreen;
import domain.character.Enemy;
import domain.character.PlayerCharacter;
import core.GameManager;

public class FightState implements GameState {
    FightScreen fightScreen = new FightScreen();

    public FightState(GameManager gameManager, PlayerCharacter player, Enemy enemy) {}

    @Override
    public void enter() {
        System.out.println("Kampf beginnt!");
        fightScreen.createScreen();
    }

    @Override
    public void update() {
        System.out.println("Kampf läuft...");
    }

    @Override
    public void exit() {
        System.out.println("Kampf vorbei.");
        fightScreen.closeScreen();
    }
}

