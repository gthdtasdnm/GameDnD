package domain.map;

import domain.character.NPC;
import domain.character.PlayerCharacter;

import java.util.List;

/**
 * Die Klasse {@code MapData} repräsentiert die Spielfeldkarte als zweidimensionales Char-Array.
 *
 * <p>Sie verwaltet die Positionen des {@link domain.character.PlayerCharacter} und aller {@link domain.character.NPC}s
 * und stellt Methoden zur Anzeige und Aktualisierung der Karte bereit.</p>
 *
 * <p>Symbole auf der Karte:</p>
 * <ul>
 *   <li>{@code '.'} = leeres Feld</li>
 *   <li>{@code '@'} = Spieler</li>
 *   <li>Großbuchstabe = erster Buchstabe eines NPC-Namens</li>
 * </ul>
 *
 * <p>Die Methode {@code isWalkable()} prüft, ob eine Position innerhalb der Kartenbegrenzung liegt.
 * {@code updatePlayerPosition()} aktualisiert die Karte nach einer Bewegung.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class MapData {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MapData.class);
    private final int width;
    private final int height;
    private final char[][] tiles;

    public MapData(int width, int height, List<NPC> npcs, PlayerCharacter player) {
        this.width = width;
        this.height = height;
        this.tiles = new char[height][width];

        // Initialisieren mit '.'
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = '.';
            }
        }

        // NPCs platzieren
        if(npcs != null) {
            for (NPC npc : npcs) {
                int x = npc.getX();
                int y = npc.getY();

                // Nur wenn Position im Bereich
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    char symbol = Character.toUpperCase(npc.getName().charAt(0));
                    tiles[y][x] = symbol;
                }
            }
        }

        // Spieler platzieren
        if(player != null) {
            tiles[player.getY()][player.getX()] = '@';
        }
    }

    public char[][] getTiles() {
    logger.info("getTiles()");        return tiles;
    }

    public void printMap() {
    logger.info("printMap()");        for (char[] row : tiles) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void updatePlayerPosition(PlayerCharacter player) {
    logger.info("updatePlayerPosition()");        // Karte vorher bereinigen (z. B. setze vorherige Position auf '.')
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (tiles[y][x] == '@') {
                    tiles[y][x] = '.';
                }
            }
        }

        int x = player.getX();
        int y = player.getY();
        tiles[y][x] = '@';
    }

    public boolean isWalkable(int x, int y) {
    logger.info("isWalkable()");        return x >= 0 && x < width && y >= 0 && y < height;
    }

}

