package data;

import character.Character;
import character.NPC;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterRepository {

    private static final Map<String, Character> characterMap = new HashMap<>();

    // Charaktere laden und speichern
    public static void loadCharacters() {
        for (NPC npc : CharacterLoader.loadNPCs("characters/oldcamp_npcs.json")) {
            characterMap.put(npc.getName(), npc);
        }
    }

    // Zugriff auf einen Charakter per ID
    public static Character getCharacter(String id) {
        return characterMap.get(id);
    }

    // Prüfen ob vorhanden
    public static boolean hasCharacter(String id) {
        return characterMap.containsKey(id);
    }

    // Alle Charaktere abrufen
    public static Collection<Character> getAllCharacters() {
        return characterMap.values();
    }

    // (Optional) Nur NPCs abrufen
    public static List<NPC> getAllNPCs() {
        return characterMap.values().stream()
                           .filter(c -> c instanceof NPC)
                           .map(c -> (NPC) c)
                           .toList();
    }

    // (Optional) Repository zurücksetzen (für Tests oder Neu-Laden)
    public static void clear() {
        characterMap.clear();
    }
}
