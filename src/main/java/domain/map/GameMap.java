package domain.map;

import java.util.Scanner;

/**
 * Eine erschreckend primitive Spielkartenklasse, die alles falsch macht, was man in moderner
 * Softwareentwicklung falsch machen kann.dd
 *
 * <p>Diese Klasse vereint auf unglückliche Weise Spielzustand, Benutzereingabe, Spiellogik und Ausgabe –
 * alles in einer einzigen, statisch durchseuchten Klasse. Objektorientierung wurde hier offensichtlich
 * als optional verstanden.</p>
 *
 * <p>Was diese Klasse (leider) tut:</p>
 * <ul>
 *   <li>Erzeugt ein hartkodiertes 10x10-Feld aus Punkten</li>
 *   <li>Bewegt einen Spielerpunkt mit WASD über die Konsole</li>
 *   <li>Druckt alles direkt über {@code System.out}</li>
 *   <li>Verwendet ausschließlich {@code static} und ignoriert jede Form von Abstraktion oder Modularisierung</li>
 * </ul>
 *
 * <p>Was diese Klasse **nicht** tut (aber sollte):</p>
 * <ul>
 *   <li>Trennung von Logik und Darstellung</li>
 *   <li>Verwendung von Objekten für Spieler, Tiles, Karten</li>
 *   <li>Skalierbarkeit, Erweiterbarkeit oder Wiederverwendbarkeit</li>
 *   <li>Irgendeine Form von Architektur, die über das erste Semester hinausgeht</li>
 * </ul>
 *
 * <p>Fazit: Ein Lehrbeispiel dafür, wie man es nicht machen sollte – aber immerhin funktional.
 * Als Spielprototyp für einen Nachmittag okay. Als Grundlage für irgendetwas Ernsthaftes: ein technisches Desaster.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */

public class GameMap {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private static int playerX = 0;
    private static int playerY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMap();

        while (true) {
            System.out.print("Bewege dich (w/a/s/d), beenden mit 'q': ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "w": move(0, -1); break;
                case "s": move(0, 1); break;
                case "a": move(-1, 0); break;
                case "d": move(1, 0); break;
                case "q": System.out.println("Spiel beendet."); return;
                default: System.out.println("Ungültige Eingabe."); break;
            }

            printMap();
        }
    }

    private static void move(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;

        if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
            playerX = newX;
            playerY = newY;
        } else {
            System.out.println("Du kannst dort nicht hin.");
        }
    }

    private static void printMap() {
        System.out.println();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print("@ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
