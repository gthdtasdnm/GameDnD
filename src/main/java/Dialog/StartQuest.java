package Dialog;

public class StartQuest implements InfoElement {
    private String questId;

    public StartQuest(String questId) {
        this.questId = questId;
    }

    @Override
    public void execute() {
        System.out.println("Quest gestartet: " + questId);
        // Hier würde dein QuestSystem eingreifen
    }
}

