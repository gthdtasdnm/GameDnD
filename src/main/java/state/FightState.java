package state;

import UI.FightScreen;
import core.GameContext;
import core.StateManager;
import org.slf4j.Logger;

/**
 * Der {@code FightState} repräsentiert den Spielzustand, in dem ein Kampf
 * zwischen dem Spieler und einem Gegner stattfindet.
 *
 * <p>Beim Betreten wird ein {@link FightScreen} erzeugt, der den Kampf visuell darstellt.
 * Während {@code update()} können z. B. Angriffe, Rundenfortschritt oder Aktionen verarbeitet werden.</p>
 *
 * <p>Nach Beendigung des Kampfes wird der Bildschirm korrekt geschlossen.</p>
 *
 * <p>Dieser Zustand ist Teil der State-Logik des {@link core.GameManager}
 * und interagiert mit {@link domain.character.PlayerCharacter} und {@link domain.character.Enemy}.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class FightState extends GameState implements GameEventListener {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(FightState.class);

    FightScreen screen;

    public FightState(GameContext context) {
        super(context);
        this.screen = new FightScreen(this);
    }

    @Override
    public void enter() {
    logger.info("enter()");        screen.createScreen();
    }

    @Override
    public void update() {
    logger.info("update()");        // Wird in diesem Zustand nicht verwendet. Reserviert für Game Loop.
    }

    @Override
    public void exit() {
    logger.info("exit()");        screen.closeScreen();
    }

    @Override
    public String getDescription() {
    logger.info("getDescription()");        return "Fight State";
    }

    @Override
    public void onUiAction(String actionId) {
    logger.info("onUiAction()");
    }


}

