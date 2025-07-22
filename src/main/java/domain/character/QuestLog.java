package domain.character;


import domain.quest.Quest;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

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
