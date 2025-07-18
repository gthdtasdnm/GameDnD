package map;

import character.NPC;
import character.PlayerCharacter;

import java.util.List;

public class MapData {
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
        for (NPC npc : npcs) {
            int x = npc.getX();
            int y = npc.getY();

            // Nur wenn Position im Bereich
            if (x >= 0 && x < width && y >= 0 && y < height) {
                char symbol = Character.toUpperCase(npc.getName().charAt(0));
                tiles[y][x] = symbol;
            }
        }

        // Spieler platzieren

        tiles[player.getY()][player.getX()] = '@';
    }

    public char[][] getTiles() {
        return tiles;
    }

    public void printMap() {
        for (char[] row : tiles) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

