package core;

import domain.character.PlayerCharacter;
import domain.map.MapData;

/**
 * Der {@code PlayerController} steuert die Bewegung des Spielercharakters auf der Karte.
 *
 * <p>Er prüft, ob eine Zielposition begehbar ist, und aktualisiert dann die Spielerposition
 * sowie die Darstellung auf der Karte.</p>
 *
 * <p>Diese Klasse kapselt die Spiellogik zur Bewegung und trennt sie vom Eingabesystem.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


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

