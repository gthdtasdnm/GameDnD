package demo;

import core.GameContext;
import core.StateManager;
import core.factory.DefaultScreenFactory;
import core.factory.ScreenFactory;
import data.DialogRepository;
import state.GameState;
import state.GameStateType;
import state.MenuState;


public class Main {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("main() gestartet");

        // Zuerst den GameContext vorbereiten
        GameContext context = new GameContext();

        // Erforderliche Komponenten setzen
        ScreenFactory screenFactory = new DefaultScreenFactory();
        context.setScreenFactory(screenFactory);

        context.setDialogRepository(new DialogRepository());

        // Jetzt StateManager initialisieren (nachdem alle Abhängigkeiten gesetzt sind)
        StateManager stateManager = new StateManager(context);
        context.setStateManager(stateManager);

        // Startzustand setzen
        GameState startState = new MenuState(context);
        stateManager.setGameState(GameStateType.MENU);

        logger.info("main() beendet");
    }
}


