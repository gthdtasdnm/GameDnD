package state;

import character.PlayerCharacter;
import map.MapData;

public class PlayerController {
    private final MapData mapData;
    private final PlayerCharacter player;

    public PlayerController(PlayerCharacter player, MapData mapData) {
        this.player = player;
        this.mapData = mapData;
    }

    public void movePlayer(int dx, int dy) {
        int newX = player.getX() + dx;
        int newY = player.getY() + dy;

        if (mapData.isWalkable(newX, newY)) {
            player.setPosition(newX, newY);
            mapData.updatePlayerPosition(player);
        }
    }
}

