package state;

import UI.ExploreScreen;
import core.GameContext;
import core.StateManager;
import org.slf4j.Logger;

/**
 * Der {@code ExploreState} repräsentiert den Spielzustand, in dem sich der Spieler frei durch die Welt bewegt.
 *
 * <p>Beim Betreten wird ein {@link ExploreScreen} erzeugt, der die aktuelle Karte darstellt.
 *
 * <p>Während des Zustands werden Spielaktionen wie Bewegung, Begegnungen oder Interaktionen verarbeitet.</p>
 *
 * <p>Beim Verlassen wird der Bildschirm korrekt geschlossen und Eingabe-Listener entfernt.</p>
 *
 * <p>Dieser Zustand ist Teil des übergeordneten {@link core.GameManager} und nutzt {@link core.PlayerController}
 * zur Spielfigurensteuerung.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class ExploreState extends GameState implements GameEventListener {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ExploreState.class);

    ExploreScreen screen;

    public ExploreState(GameContext context) {
        super(context);
        this.screen = new ExploreScreen(this);
    }

    @Override
    public void enter() {
    logger.info("enter()");        screen.createScreen();
        //mapScreen.getFrame().addKeyListener(new ArrowKeyListener(controller, mapScreen));
    }

    @Override
    public void update() {
    logger.info("update()");        // Wird in diesem Zustand nicht verwendet. Reserviert für Game Loop.
    }

    @Override
    public void exit() {
    logger.info("exit()");    }

    @Override
    public String getDescription() {
    logger.info("getDescription()");        return "Explore State";
    }

    @Override
    public void onUiAction(String actionId) {
    logger.info("onUiAction()");
    }


}

