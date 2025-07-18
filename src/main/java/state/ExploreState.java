package state;

import UI.MapScreen;
import character.PlayerCharacter;
import map.MapData;

public class ExploreState implements GameState {
    MapScreen mapScreen = new MapScreen();

    public ExploreState(GameManager gameManager, PlayerCharacter player, MapData mapData) {}

    @Override
    public void enter() {
        System.out.println("Betrete Erkundungsmodus");
        mapScreen.createScreen();
    }

    @Override
    public void update() {
        System.out.println("Spieler läuft durch die Welt");
        // z.B. auf Input reagieren
    }

    @Override
    public void exit() {
        System.out.println("Verlasse Erkundungsmodus");
        mapScreen.closeScreen();

    }
}

