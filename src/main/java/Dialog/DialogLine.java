package Dialog;

import character.CharacterState;

public class DialogLine {
    private String description;
    private int priority;// Was im Menü angezeigt wird
    private boolean isPermanent;
    private boolean isImportant;
    private Condition condition; // Interface
    private Runnable action;     // Was passiert, wenn ausgewählt

    public DialogLine(String description, int priority, boolean isPermanent, boolean isImportant, Condition condition, Runnable action) {
        this.description = description;
        this.priority = priority;
        this.isPermanent = isPermanent;
        this.isImportant = isImportant;
        this.condition = condition;
        this.action = action;//Script function to be called when this information got selected in the dialogue menu.
    }

    public boolean isVisible(CharacterState player) {
        return condition == null || condition.evaluate(player);
    }

    public void runAction() {
        if (action != null) action.run();
    }

    // Getter: getText(), getId(), isPermanent(), ...
}

