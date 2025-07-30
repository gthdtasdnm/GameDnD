package state;

import core.StateManager;
import UI.DialogScreen;
import data.DialogRepository;
import domain.dialog.DialogInstance;
import domain.dialog.DialogLine;
import domain.dialog.InfoElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Der {@code DialogState} repräsentiert den Spielzustand, in dem sich der Spieler
 * in einem aktiven Dialog mit einem NPC befindet.
 *
 * <p>Beim Betreten des Zustands wird ein {@link DialogScreen} erstellt,
 * der den Dialog visuell darstellt. Während {@code update()} können z. B.
 * Eingaben verarbeitet oder Dialogoptionen ausgewählt werden.</p>
 *
 * <p>Beim Verlassen des Zustands wird der Dialogbildschirm geschlossen.</p>
 *
 * <p>Dieser Zustand ist Teil der State-Logik im {@link core.GameManager}.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class DialogState extends GameState implements GameEventListener{
    DialogScreen screen;
    //DialogRepository dialogRepository = new DialogRepository();
    //List<DialogInstance> dialogs = dialogRepository.getAllDialogs();
    Map<String, DialogInstance> dialogOptions = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(DialogState.class);

    public DialogState(StateManager stateManager, List<DialogInstance> dialogOptions) {
        super(stateManager);
        this.screen = new DialogScreen(this);
        for(DialogInstance dialogInstance:dialogOptions){
            this.dialogOptions.put(dialogInstance.getDescription(),dialogInstance);
        }
    }

    @Override
    public void enter() {
        screen.createScreen();
        //TODO: Dialog wird als String übergeben um die Option anzuzeigen.
        //TODO: Ziel ist es eine ganze Dialoginstanz zu übergeben und damit die Sprecher und die Dialogzeilen anzuzeigen.
        for(DialogInstance dialogInstance: dialogOptions.values()){
            screen.addOption(dialogInstance);
        }
    }

    @Override
    public void update() {
        // Wird in diesem Zustand nicht verwendet. Reserviert für Game Loop.
    }

    @Override
    public void exit() {
        screen.closeScreen();
    }

    @Override
    public String getDescription() {
        return "Dialog State";
    }


    public void onUiAction(String actionID) {
        if(actionID == "ENDE"){
            stateManager.setGameState(new ExploreState(stateManager));
        }else{
            for(InfoElement dialogLine: dialogOptions.get(actionID).getInformation().getElements()){
                screen.addDialog(dialogLine.getSpeaker() + ": " + dialogLine.getText());
            }
        }

    }
}

