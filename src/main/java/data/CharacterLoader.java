package data;

import domain.character.NPC;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Die {@code CharacterLoader}-Klasse lädt NPC-Daten aus einer JSON-Ressourcendatei.
 *
 * <p>Sie verwendet {@code Gson}, um eine Liste von {@link domain.character.NPC}-Objekten
 * aus einer im Ressourcenpfad befindlichen Datei zu deserialisieren.</p>
 *
 * <p>Wird die Datei nicht gefunden oder tritt ein Fehler beim Einlesen auf,
 * wird eine leere Liste zurückgegeben.</p>
 *
 * <p>Beispielnutzung:</p>
 * <pre>{@code
 * List<NPC> npcs = CharacterLoader.loadNPCs("npcs.json");
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class CharacterLoader {

    public static List<NPC> loadNPCs(String resourcePath) {
        InputStream input = CharacterLoader.class.getClassLoader().getResourceAsStream(resourcePath);

        if (input == null) {
            System.err.println("NPC-Datei nicht gefunden: " + resourcePath);
            return Collections.emptyList();
        }

        try (InputStreamReader reader = new InputStreamReader(input)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<NPC>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            System.err.println("Fehler beim Laden der NPCs aus: " + resourcePath);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
