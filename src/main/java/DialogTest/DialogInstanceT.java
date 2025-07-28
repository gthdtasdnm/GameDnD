package DialogTest;

import java.util.List;

public class DialogInstanceT {
    private final String id;
    private final String description;
    private final boolean isPermanent;
    private final boolean isImportant;
    private final ConditionT condition;
    private final Runnable onSelect;

    public DialogInstanceT(String id, String description, boolean isPermanent, boolean isImportant,
                          ConditionT condition, Runnable onSelect) {
        this.id = id;
        this.description = description;
        this.isPermanent = isPermanent;
        this.isImportant = isImportant;
        this.condition = condition;
        this.onSelect = onSelect;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public boolean isAvailable() {
        return condition == null || condition.check();
    }

    public void execute() {
        onSelect.run();
    }
}

