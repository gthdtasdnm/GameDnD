package state;

import UI.GUI.MapScreen;
import domain.character.PlayerCharacter;
import core.GameManager;
import core.PlayerController;
import domain.map.MapData;

/**
 * Der {@code ExploreState} repräsentiert den Spielzustand, in dem sich der Spieler frei durch die Welt bewegt.
 *
 * <p>Beim Betreten wird ein {@link UI.GUI.MapScreen} erzeugt, der die aktuelle Karte darstellt.
 * Zusätzlich wird ein {@link UI.Input.ArrowKeyListener} registriert, um Bewegungen mit den Pfeiltasten zu ermöglichen.</p>
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


public class ExploreState implements GameState {

    //TODO Eingabe und ausgabe auslagern in andere Klassen
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
        mapScreen.closeScreen();
    }

    @Override
    public String getDescription() {
        return "Explore State";
    }
}

