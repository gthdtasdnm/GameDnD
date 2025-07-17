package Dialog;

public class DialogLine {
    private String description;  // text of the dialog line
    private int priority;        // Priority in the dialog select menu
    private boolean isPermanent; // If yes the dialog option is repeatable
    private boolean isImportant; // If yes NPC will stop you and talk to you
    private Condition condition; // Conditions to show dialog as an option
    private Runnable action;     // Script function to be called when this information got selected in the dialogue menu.
    private String nextId;       //reference to the id of the next dialog line

    public DialogLine(String description, int priority, boolean isPermanent, boolean isImportant, Condition condition, Runnable action, String nextId) {
        this.description = description;
        this.priority = priority;
        this.isPermanent = isPermanent;
        this.isImportant = isImportant;
        this.condition = condition;
        this.action = action;
        this.nextId = nextId;
    }

    public void runAction() {
        if (action != null) action.run();
    }

    // Getter: getText(), getId(), isPermanent(), ...
}

