package state;

import Dialog.DialogInstance;
import character.Enemy;
import character.PlayerCharacter;
import map.MapData;

public class GameManager {
    private GameContext gameContext; // State-Maschine
    private PlayerCharacter player;
    private MapData mapData;

    public GameManager() {
        this.player = new PlayerCharacter();
        this.mapData = new MapData(65, 15);
        this.gameContext = GameContext.getInstance();
    }

    public void startGame() {
        ExploreState explore = new ExploreState(this, player, mapData);
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
        ExploreState explore = new ExploreState(this, player, mapData);
        gameContext.setState(explore);
    }
}

