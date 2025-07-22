package domain.character;


import domain.quest.Quest;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

/**
 * Die Klasse {@code QuestLog} verwaltet alle aktiven Quests eines Charakters.
 *
 * <p>Sie speichert {@link domain.quest.Quest}-Objekte anhand ihrer ID
 * und ermöglicht das Hinzufügen, Entfernen und Abfragen laufender Quests.</p>
 *
 * <p>Wird typischerweise einem {@code PlayerCharacter} oder {@code NPC} zugeordnet,
 * um den Fortschritt einzelner Aufgaben zu verfolgen.</p>
 *
 * <p>Typische Nutzung:</p>
 * <pre>{@code
 * QuestLog log = new QuestLog();
 * log.addQuest(new Quest("find_ore", "Finde magisches Erz"));
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class QuestLog {

    private final Map<String, Quest> activeQuests = new HashMap<>();

    // Quest hinzufügen
    public void addQuest(Quest quest) {
        activeQuests.put(quest.getId(), quest);
    }

    // Quest entfernen
    public void removeQuest(String questId) {
        activeQuests.remove(questId);
    }

    // Eine bestimmte Quest holen
    public Quest getQuest(String questId) {
        return activeQuests.get(questId);
    }

    // Alle aktiven Quests
    public Collection<Quest> getAllQuests() {
        return activeQuests.values();
    }

    // Prüfen, ob eine bestimmte Quest aktiv ist
    public boolean hasQuest(String questId) {
        return activeQuests.containsKey(questId);
    }
}
