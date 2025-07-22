package state;

import UI.Input.ArrowKeyListener;
import UI.GUI.MapScreen;
import domain.character.PlayerCharacter;
import core.GameManager;
import core.PlayerController;
import domain.map.MapData;

public class ExploreState implements GameState {
    GameManager gameManager;
    PlayerCharacter player;
    MapData mapData;
    MapScreen mapScreen;
    PlayerController controller;


    public ExploreState(GameManager gameManager, PlayerCharacter player, MapData mapData, PlayerController controller) {
        this.gameManager = gameManager;
        this.player = player;
        this.mapData = mapData;
        this.controller = controller;
    }

    @Override
    public void enter() {
        System.out.println("Betrete Erkundungsmodus");
        mapScreen = new MapScreen(mapData);
        mapScreen.createScreen();
        mapScreen.getFrame().addKeyListener(new ArrowKeyListener(controller, mapScreen));
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

