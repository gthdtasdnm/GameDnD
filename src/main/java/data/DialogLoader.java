package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import domain.dialog.DialogInstance;
import domain.dialog.Information;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Die {@code DialogLoader}-Klasse lädt Dialoge aus einer JSON-Datei
 * und ordnet sie pro NPC zu.
 *
 * Beispielnutzung:
 * <pre>{@code
 * Map<String, List<DialogInstance>> dialogMap = DialogLoader.loadDialogMap("dialogs_intro.json");
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-30
 */
public class DialogLoader {
    private static final Logger logger = LoggerFactory.getLogger(DialogLoader.class);

    /**
     * Lädt die Dialoge aus einer JSON-Datei im Ressourcenpfad und gibt eine Map zurück,
     * die jedem NPC eine Liste seiner Dialoginstanzen zuordnet.
     *
     * @param resourcePath Pfad zur JSON-Datei (z. B. "dialogs_intro.json")
     * @return Map mit NPC-Namen als Schlüssel und zugehörigen Dialoglisten
     */
    public static Map<String, List<DialogInstance>> loadDialogMap(String resourcePath) {
        logger.info("loadDialogMap(): " + resourcePath);
        List<DialogInstance> dialogs = loadDialogs();

        Map<String, List<DialogInstance>> dialogMap = new HashMap<>();
        for (DialogInstance dialog : dialogs) {
            String npc = dialog.getNpc();
            if (npc == null || npc.isBlank()) continue;
            dialogMap.computeIfAbsent(npc, k -> new ArrayList<>()).add(dialog);
        }

        return dialogMap;
    }

    /**
     * Lädt die Dialoge aus der JSON-Datei und gibt sie als Liste zurück.
     *
     * @return Liste der geladenen Dialoginstanzen
     */
    public static List<DialogInstance> loadDialogs() {
        logger.info("loadDialogs()");
        InputStream input = DialogLoader.class.getClassLoader().getResourceAsStream(ConfigService.get("dialogs.path"));


        if (input == null) {
            logger.error("Dialogdatei nicht gefunden: " + ConfigService.get("dialogs.path"));
            return Collections.emptyList();
        }

        try (InputStreamReader reader = new InputStreamReader(input)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Information.class, new InformationDeserializer())
                    .create();

            Type listType = new TypeToken<List<DialogInstance>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            logger.error("Fehler beim Laden der Dialoge aus: " + ConfigService.get("dialogs.path"), e);
            return Collections.emptyList();
        }
    }
}
