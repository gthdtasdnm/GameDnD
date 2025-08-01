package demo;

import UI.MainFrame;
import UI.MenuPanel;
import UI.ScreenManager;
import core.GameContext;
import core.StateManager;
import core.factory.DefaultScreenFactory;
import data.DialogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import state.GameStateType;
import state.MenuState;

import javax.swing.*;

public class screenTest {
    private static final Logger logger = LoggerFactory.getLogger(screenTest.class);

    public static void main(String[] args) {
        logger.info("Screentest");

        // 1. Hauptfenster erzeugen
        MainFrame frame = new MainFrame();
        ScreenManager.init(frame);

        // 3. Panel erstellen
        MenuPanel menuPanel = new MenuPanel();

        // 4. Panel im Hauptfenster anzeigen
        ScreenManager.showScreen(menuPanel.getPanel());

        // 5. Fenster sichtbar machen
        frame.setVisible(true);


    }
}
