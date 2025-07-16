package data;

import character.NPC;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

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
