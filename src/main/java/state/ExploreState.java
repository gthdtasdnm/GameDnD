package state;

import UI.MapScreen;
import character.PlayerCharacter;
import map.MapData;

public class ExploreState implements GameState {
    GameManager gameManager;
    PlayerCharacter player;
    MapData mapData;
    MapScreen mapScreen;


    public ExploreState(GameManager gameManager, PlayerCharacter player, MapData mapData) {
        this.gameManager = gameManager;
        this.player = player;
        this.mapData = mapData;
    }

    @Override
    public void enter() {
        System.out.println("Betrete Erkundungsmodus");
        mapScreen = new MapScreen(mapData);
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

