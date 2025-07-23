package data;

import domain.dialog.Condition;
import domain.dialog.DialogInstance;
import domain.dialog.DialogLine;
import domain.dialog.Information;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DialogRepository {
    //TODO: Läd die Dialoge mit dem DialogLoader aus einer json in eine HashMap
    //Jetzt nur provisorisch aufgebaut, um DialogManager zu machen
//    private String npc;
//    private String description;         // Option text shown in dialog menu
//    private int priority;               // Priority in the dialog select menu
//    private boolean isPermanent;        // If yes the dialog option is repeatable
//    private boolean isImportant;        // If yes NPC will stop you and talk to you
//    private Condition condition;        // Conditions to show dialog as an option
//    private Information information;    // Script function to be called when this information got selected in the dialogue menu. hat dialog lines

    List<DialogInstance> dialogRepository = new ArrayList<>();

    public DialogRepository() {
        loadDialogs();
    }

    private void loadDialogs() {
        String npc = "Diego";
        String description = "Hallo";
        int priority = 1;
        boolean isPermanent = true;
        boolean isImportant = false;
        Condition condition = null;

        Information information = new Information();
        DialogLine dialogLine1 = new DialogLine("1", "Hallo, ich bin Diego.");
        DialogLine dialogLine2 = new DialogLine("2", "Du solltest lieber aufpassen, wo du hinläufst.");

        information.add(dialogLine1);
        information.add(dialogLine2);

        DialogInstance instance = new DialogInstance(
                description,
                priority,
                isPermanent,
                isImportant,
                condition,
                information
        );

        dialogRepository.add(instance);
    }

    public List<DialogInstance> getAllDialogs() {
        return dialogRepository;
    }





}
