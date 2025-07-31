package state;

import core.GameContext;
import UI.DialogScreen;
import domain.dialog.DialogInstance;
import domain.dialog.InfoElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Der {@code DialogState} repräsentiert den Spielzustand, in dem sich der Spieler
 * in einem aktiven Dialog mit einem NPC befindet.
 *
 * Beim Betreten des Zustands wird ein {@link DialogScreen} erstellt,
 * der den Dialog visuell darstellt.
 *
 * Beim Verlassen des Zustands wird der Dialogbildschirm geschlossen.
 *
 * Autor: Cengiz
 * Stand: 2025-07-30
 */
public class DialogState extends GameState implements GameEventListener {
    private static final Logger logger = LoggerFactory.getLogger(DialogState.class);

    private final DialogScreen screen;
    private final Map<String, DialogInstance> dialogOptions = new LinkedHashMap<>();

    public DialogState(GameContext context) {
        super(context);
        this.screen = new DialogScreen(this);

        List<DialogInstance> dialogList = context.getDialogRepository().getDialogsByNpc("Diego");
        for (DialogInstance dialog : dialogList) {
            dialogOptions.put(dialog.getDescription(), dialog);
        }

        logger.info("DialogState() erstellt mit " + dialogOptions.size() + " Optionen");
    }

    @Override
    public void enter() {
        logger.info("enter()");
        screen.createScreen();

        for (DialogInstance dialog : dialogOptions.values()) {
            logger.info("Dialogoption: " + dialog.getDescription());
            screen.addOption(dialog);
        }
    }

    @Override
    public void update() {
        logger.info("update()");
        // Keine kontinuierliche Logik in diesem State
    }

    @Override
    public void exit() {
        logger.info("exit()");
        screen.closeScreen();
    }

    @Override
    public String getDescription() {
        return "Dialog State";
    }

    @Override
    public void onUiAction(String actionID) {
        logger.info("onUiAction(): " + actionID);

        if ("ENDE".equals(actionID)) {
            stateManager.setGameState(GameStateType.EXPLORE);
            return;
        }

        DialogInstance selected = dialogOptions.get(actionID);
        if (selected == null) {
            logger.warn("Unbekannte Dialogoption: " + actionID);
            return;
        }

        for (InfoElement element : selected.getInformation().getElements()) {
            screen.addDialog(element.getSpeaker() + ": " + element.getText());
        }
    }
}
