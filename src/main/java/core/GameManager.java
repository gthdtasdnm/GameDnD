package core;

import domain.dialog.DialogInstance;
import domain.character.Enemy;
import domain.character.NPC;
import domain.character.PlayerCharacter;
import data.CharacterRepository;
import domain.map.MapData;
import domain.inventory.Equipment;
import domain.inventory.Inventory;
import state.DialogState;
import state.ExploreState;
import state.FightState;
import state.GameContext;

import java.util.List;


/**
 * Der {@code GameManager} ist die zentrale Steuerungseinheit des Spiels.
 *
 * <p>Er initialisiert Spielfiguren, Karte, Controller und verwaltet den aktuellen Spielzustand
 * über die State-Maschine {@link GameContext}.</p>
 *
 * <p>Der {@code GameManager} wechselt dynamisch zwischen verschiedenen Spielzuständen wie:</p>
 * <ul>
 *   <li>{@link ExploreState} – Erkundung der Spielwelt</li>
 *   <li>{@link FightState} – Kampf gegen Gegner</li>
 *   <li>{@link DialogState} – Gespräche mit NPCs</li>
 * </ul>
 *
 * <p>Diese Klasse bildet die Brücke zwischen Spiellogik, Spielwelt und Zustandsverwaltung.</p>
 *
 * <p>Verwendung:</p>
 * <pre>{@code
 * GameManager manager = new GameManager();
 * manager.startGame(); // beginnt mit Erkundung
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */

public class GameManager {
    private GameContext gameContext; // State-Maschine
    private PlayerCharacter player = new PlayerCharacter("Held", "oldcamp", 100,  10, 10, new Inventory(), new Equipment());
    private List<NPC> npcs;
    private MapData mapData;
    private PlayerController controller;


    public GameManager() {
        CharacterRepository.loadCharacters();
        this.npcs = CharacterRepository.getAllNPCs();
        mapData = new MapData(20, 10, npcs, player);
        controller = new PlayerController(player, mapData);
        this.gameContext = GameContext.getInstance();
    }

    public void startGame() {
        ExploreState explore = new ExploreState(this, player, mapData, controller);
        gameContext.setState(explore);
    }

    public void enterFight(Enemy enemy) {
        FightState fight = new FightState(this, player, enemy);
        gameContext.setState(fight);
    }

    public void enterDialog(DialogInstance dialog) {
        DialogState dialogState = new DialogState(this, dialog);
        gameContext.setState(dialogState);
    }

    public void returnToExplore() {
        ExploreState explore = new ExploreState(this, player, mapData, controller);
        gameContext.setState(explore);
    }

}

