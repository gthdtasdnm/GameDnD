package main.UI;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

public class LanternaMenuDemo {
    public static void Menu() throws IOException {
        // Terminal vorbereiten
        Screen screen = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(40, 15))
                .setPreferTerminalEmulator(true)
                .setTerminalEmulatorTitle("Schwarz-Weiß-Menü")
                .createScreen();
        screen.startScreen();

        // GUI erstellen
        MultiWindowTextGUI gui = new MultiWindowTextGUI(
                screen,
                new DefaultWindowManager(),
                new EmptySpace(TextColor.ANSI.BLACK)  // Hintergrund schwarz
        );

        // Optional: Schriftfarbe standardmäßig auf weiß setzen
        gui.setTheme(new SimpleTheme(TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));


        // Fenster
        BasicWindow window = new BasicWindow("Menü");
        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

        // Optionen
        String[] optionen = {"Spiel starten", "Einstellungen", "Beenden"};

        for (String option : optionen) {
            Button button = new Button(option, () -> {
                System.out.println("Ausgewählt: " + option);
            });

            // Schwarz-weißer Stil ohne benutzerdefinierten Renderer (funktioniert stabil)
            panel.addComponent(button);
        }

        window.setComponent(panel);
        gui.addWindowAndWait(window);

        screen.stopScreen();
    }
}
