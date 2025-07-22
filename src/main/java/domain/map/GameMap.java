package domain.map;

import java.util.Scanner;

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
