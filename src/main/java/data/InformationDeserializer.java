package data;


import com.google.gson.*;
import domain.dialog.DialogLine;
import domain.dialog.Information;
import domain.dialog.InfoElement;

import java.lang.reflect.Type;

public class InformationDeserializer implements JsonDeserializer<Information> {

    @Override
    public Information deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Information info = new Information();

        if (json.isJsonArray()) {
            JsonArray array = json.getAsJsonArray();

            for (JsonElement elem : array) {
                JsonObject obj = elem.getAsJsonObject();
                String type = obj.get("type").getAsString();

                InfoElement element;

                switch (type) {
                    case "DialogLine" -> element = context.deserialize(obj, DialogLine.class);
                    // case "StartQuest" -> element = context.deserialize(obj, StartQuest.class);
                    // Weitere Typen hier...
                    default -> throw new JsonParseException("Unbekannter InfoElement-Typ: " + type);
                }

                info.add(element);
            }
        } else {
            throw new JsonParseException("Expected an array for Information but got: " + json);
        }

        return info;
    }
}

