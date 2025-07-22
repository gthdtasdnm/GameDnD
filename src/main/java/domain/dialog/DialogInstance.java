package domain.dialog;

public class DialogInstance {
    private String npc;
    private String description;         // Option text shown in dialog menu
    private int priority;               // Priority in the dialog select menu
    private boolean isPermanent;        // If yes the dialog option is repeatable
    private boolean isImportant;        // If yes NPC will stop you and talk to you
    private Condition condition;        // Conditions to show dialog as an option
    private Information information;    // Script function to be called when this information got selected in the dialogue menu. hat dialog lines


    public DialogInstance(String description, int priority, boolean isPermanent, boolean isImportant, Condition condition, Information information) {
        this.description = description;
        this.priority = priority;
        this.isPermanent = isPermanent;
        this.isImportant = isImportant;
        this.condition = condition;
        this.information = information;
    }

    public void run(){
        if(condition.checkAll()){
            information.processAll();
        }
    }


    // Getter: getText(), getId(), isPermanent(), ...
}

