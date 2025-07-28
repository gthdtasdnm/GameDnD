package domain.dialog;

/**
 * Die Klasse {@code StartQuest} ist ein {@link InfoElement}, das beim Ausführen
 * eine Quest mit der angegebenen ID startet.
 *
 * <p>Derzeit wird nur eine Textausgabe erzeugt. In einer späteren Version
 * sollte das Quest-System eingebunden werden, um die Quest dem {@code QuestLog}
 * des Spielers hinzuzufügen.</p>
 *
 * <p>Typischer Bestandteil eines {@link Information}-Blocks innerhalb eines Dialogs.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class StartQuest implements InfoElement {
    private String questId;

    public StartQuest(String questId) {
        this.questId = questId;
    }

    @Override
    public String getSpeaker() {
        return "";
    }

    @Override
    public String getText() {
        return "";
    }

    @Override
    public void execute() {
        //TODO es soll ein Quest Objekt dem Questlog des Spielers hinzugefügt werden.
        System.out.println("Quest gestartet: " + questId);
        // Hier würde dein QuestSystem eingreifen
    }
}

