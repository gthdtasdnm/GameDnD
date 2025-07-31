package data;

import domain.dialog.Condition;
import domain.dialog.DialogInstance;
import domain.dialog.DialogLine;
import domain.dialog.Information;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DialogRepository {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DialogRepository.class);
    //TODO: Läd die Dialoge mit dem DialogLoader aus einer json in eine HashMap

    List<DialogInstance> dialogRepository = new ArrayList<>();
    Map<String, List<DialogInstance>> dialogMap = DialogLoader.loadDialogMap("dialogs/dialogs.json");


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
        DialogLine dialogLine1 = new DialogLine("1","dummy", "Hallo, ich bin Diego.");
        DialogLine dialogLine2 = new DialogLine("2","dummy", "Du solltest lieber aufpassen, wo du hinläufst.");

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
    logger.info("getAllDialogs()");
    return dialogRepository;
    }

    public List<DialogInstance> getIntroDialogs() {
        logger.info("getIntroDialogs()");
        List<DialogInstance> dialogs = new ArrayList<>();

        // Dialog 1
        Information info1 = new Information();
        info1.add(new DialogLine("1", "Diego", "Hey du! Bist du neu hier?"));
        info1.add(new DialogLine("2", "Held", "Das kommt drauf an."));
        info1.add(new DialogLine("3", "Diego", "Ich bin Diego. Und wenn du Hilfe brauchst, solltest du dich mit mir gut stellen."));
        dialogs.add(new DialogInstance("Diego", "Wer bist du?", info1));

        // Dialog 2
        Information info2 = new Information();
        info2.add(new DialogLine("1", "Held", "Wo bin ich hier?"));
        info2.add(new DialogLine("2", "Diego", "In der Kolonie. Oder besser gesagt: im alten Lager, mitten in der Barriere."));
        info2.add(new DialogLine("3", "Diego", "Die Magier haben die Barriere erschaffen, um die Strafkolonie einzusperren. Nur reinkommen ist einfach – raus kommt keiner."));
        dialogs.add(new DialogInstance("Diego", "Wo bin ich?", info2));

        // Dialog 3
        Information info3 = new Information();
        info3.add(new DialogLine("1", "Held", "Was soll ich jetzt tun?"));
        info3.add(new DialogLine("2", "Diego", "Das hängt ganz von dir ab. Schließ dich einem Lager an, lern kämpfen – oder du wirst hier nicht lange überleben."));
        info3.add(new DialogLine("3", "Diego", "Wenn du schlau bist, kommst du mit mir. Ich zeige dir das Alte Lager."));
        dialogs.add(new DialogInstance("Diego", "Was soll ich tun?", info3));

        // Ende
        dialogs.add(new DialogInstance());

        return dialogs;
    }

    public List<DialogInstance> getDialogsByNpc(String npcName) {
        logger.info("getDialogsByNpc(): " + npcName);
        List<DialogInstance> original = dialogMap.getOrDefault(npcName, List.of());

        // Neue Liste kopieren und ENDE hinzufügen
        List<DialogInstance> extended = new ArrayList<>(original);
        extended.add(new DialogInstance()); // Leere Instanz als "ENDE"
        return extended;
    }








}
