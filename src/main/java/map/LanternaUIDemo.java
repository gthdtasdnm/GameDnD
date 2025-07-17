package map;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaUIDemo {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private static int playerX = 0;
    private static int playerY = 0;

    public static void main(String[] args) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(WIDTH, HEIGHT))
                .setPreferTerminalEmulator(true)
                .setTerminalEmulatorTitle("Kartenbewegung");

        Screen screen = terminalFactory.createScreen();
        screen.startScreen();
        screen.setCursorPosition(null);

        drawMap(screen);

        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.EOF || key.getKeyType() == KeyType.Escape) {
                break;
            }

            switch (key.getKeyType()) {
                case ArrowUp -> playerY = Math.max(0, playerY - 1);
                case ArrowDown -> playerY = Math.min(HEIGHT - 1, playerY + 1);
                case ArrowLeft -> playerX = Math.max(0, playerX - 1);
                case ArrowRight -> playerX = Math.min(WIDTH - 1, playerX + 1);
            }

            drawMap(screen);
        }

        screen.stopScreen();
    }

    private static void drawMap(Screen screen) throws IOException {
        screen.clear();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x == playerX && y == playerY) {
                    screen.setCharacter(x, y, new com.googlecode.lanterna.TextCharacter('@', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
                } else {
                    screen.setCharacter(x, y, new com.googlecode.lanterna.TextCharacter('.', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
                }
            }
        }
        screen.refresh();
    }
}
