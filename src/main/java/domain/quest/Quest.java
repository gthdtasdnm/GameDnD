package domain.quest;

import domain.item.Item;

import java.util.List;

/**
 * Die Klasse {@code Quest} repräsentiert eine Aufgabe im Spiel, die von einem NPC
 * vergeben werden kann und dem Spieler bei Abschluss Belohnungen gewährt.
 *
 * <p>Eine Quest enthält eine eindeutige ID, einen Namen, eine Beschreibung sowie
 * Belohnungen in Form von Erfahrung, Gold und Items.</p>
 *
 * <p>Geplant ist die Ergänzung um vollständige Getter-Methoden und einen Konstruktor.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class Quest {
    private String id;
    private String name;
    private String description;
    private int experienceReward;
    private int goldReward;
    private List<Item> itemReward;

    public String getId() {return id;}

    //TODO:Methoden Getter Konstruktor
}
