package data;

import domain.character.Character;
import domain.character.NPC;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Die {@code CharacterRepository}-Klasse stellt ein zentrales Speicher- und Zugriffsmodul
 * für alle geladenen {@link domain.character.Character}-Objekte dar.
 *
 * <p>Sie lädt NPCs aus einer JSON-Datei und speichert sie intern in einer Map,
 * wodurch der Zugriff über Namen (IDs) möglich ist.</p>
 *
 * <p>Funktionen umfassen:</p>
 * <ul>
 *   <li>Laden von Charakteren aus Dateien</li>
 *   <li>Zugriff auf einzelne oder alle Charaktere</li>
 *   <li>Filterung nach {@link domain.character.NPC}</li>
 *   <li>Zurücksetzen des Repositories</li>
 * </ul>
 *
 * <p>Beispiel:</p>
 * <pre>{@code
 * CharacterRepository.loadCharacters();
 * Character diego = CharacterRepository.getCharacter("Diego");
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


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
