package demo;

import core.GameContext;
import core.StateManager;
import core.factory.DefaultScreenFactory;
import data.DialogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import state.GameStateType;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("main() gestartet");

        // 1. Kontext vorbereiten
        GameContext context = new GameContext();
        context.setScreenFactory(new DefaultScreenFactory());
        context.setDialogRepository(new DialogRepository());

        // 2. StateManager erstellen und direkt im Kontext registrieren
        StateManager stateManager = new StateManager(context); // Achtung: setzt context.setStateManager() intern

        // 3. Startzustand setzen (STATE wird vom StateManager intern erzeugt)
        stateManager.setGameState(GameStateType.MENU);

        logger.info("main() beendet");
    }
}
