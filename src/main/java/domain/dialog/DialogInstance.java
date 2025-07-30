package domain.dialog;

/**
 * Die Klasse {@code DialogInstance} repräsentiert eine einzelne Dialogoption
 * in einem Gespräch mit einem NPC.
 *
 * <p>Eine Dialoginstanz enthält:</p>
 * <ul>
 *   <li>einen Beschreibungstext für das Dialogmenü</li>
 *   <li>eine Priorität zur Sortierung</li>
 *   <li>Informationen über Wiederholbarkeit und Wichtigkeit</li>
 *   <li>eine {@link Condition}, um anzuzeigen, ob die Option verfügbar ist</li>
 *   <li>eine {@link Information}, die beim Auswählen ausgeführt wird</li>
 * </ul>
 *
 * <p>Die Methode {@code run()} prüft alle Bedingungen und führt bei Erfolg die zugehörige Logik aus.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class DialogInstance {
    private String npc;
    private String description;         // Option text shown in dialog menu
    private int priority;               // Priority in the dialog select menu
    private boolean isPermanent;        // If yes the dialog option is repeatable
    private boolean isImportant;        // If yes NPC will stop you and talk to you
    private Condition condition;        // Conditions to show dialog as an option
    private Information information;    // Script function to be called when this information got selected in the dialogue menu. hat dialog lines


    public DialogInstance(
            String description,
            int priority,
            boolean isPermanent,
            boolean isImportant,
            Condition condition,
            Information information) {
        this.description = description;
        this.priority = priority;
        this.isPermanent = isPermanent;
        this.isImportant = isImportant;
        this.condition = condition;
        this.information = information;
    }

    //ENDE
    public DialogInstance(){
        this.npc = null;
        this.description = "ENDE";
        this.priority = 1;
        this.isPermanent = false;
        this.isImportant = false;
        this.condition = null;
        this.information = null;
    }

    //Testing
    public DialogInstance(String npc, String description, Information information){
        this.npc = npc;
        this.description = description;
        this.priority = 1;
        this.isPermanent = false;
        this.isImportant = false;
        this.condition = null;
        this.information = information;
    }

    public void run(){
        if(condition.checkAll()){
            information.processAll();
        }
    }

    public String getDescription() {
        return description;
    }

    public Information getInformation() {
        return information;
    }

    public String getNPC() {
        return npc;
    }

    // Getter: getText(), getId(), isPermanent(), ...
}

