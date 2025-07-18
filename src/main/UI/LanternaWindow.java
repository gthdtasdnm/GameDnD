package main.UI;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

public class LanternaWindow {
    public void window() throws IOException {
        // Terminal erstellen
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setTerminalEmulatorTitle("Mein Fenster")
                .setPreferTerminalEmulator(true);  // GUI-Modus (nicht stty.exe)

        Screen screen = terminalFactory.createScreen();
        screen.startScreen();

        // GUI mit schwarzem Hintergrund
        MultiWindowTextGUI gui = new MultiWindowTextGUI(
                screen,
                new DefaultWindowManager(),
                new EmptySpace(TextColor.ANSI.BLACK)  // Hintergrund: Schwarz
        );

        // Setze weiß auf schwarz als Theme
        gui.setTheme(new SimpleTheme(TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));

        // Fenster erstellen
        BasicWindow window = new BasicWindow("Mein erstes Fenster");

        Panel contentPanel = new Panel();
        contentPanel.setLayoutManager(new LinearLayout());

        contentPanel.addComponent(new Label("Hallo Welt!"));
        contentPanel.addComponent(new Button("OK", () -> {
            System.out.println("Button gedrückt!");
        }));

        window.setComponent(contentPanel);
        gui.addWindowAndWait(window);

        screen.stopScreen();

    }
}
