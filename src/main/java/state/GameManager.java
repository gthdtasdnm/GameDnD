package state;

import Dialog.DialogInstance;
import UI.ArrowKeyListener;
import character.Enemy;
import character.NPC;
import character.PlayerCharacter;
import data.CharacterRepository;
import map.MapData;
import models.Equipment;
import models.Inventory;

import java.util.List;

public class GameManager {
    private GameContext gameContext; // State-Maschine
    private PlayerCharacter player = new PlayerCharacter("Held", "oldcamp", 100, 100, 10, 10, new Inventory(), new Equipment());
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

