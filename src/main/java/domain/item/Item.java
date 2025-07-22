package domain.item;

/**
 * Die abstrakte Klasse {@code Item} stellt die gemeinsame Basis für alle Gegenstände im Spiel dar.
 *
 * <p>Jedes Item besitzt eine eindeutige ID, einen Namen, eine Beschreibung und einen Preis.
 * Diese Informationen werden zur Darstellung, Verwaltung und für Transaktionen verwendet.</p>
 *
 * <p>Konkrete Subtypen sind z. B. {@link Armor}, {@link Weapon} oder {@link Consumable}.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public abstract class Item {
    protected final String id;
    protected final String name;
    protected final String description;
    protected final int price;

    protected Item(String id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {return name;}

    public int getPrice() {return price;}

    public String getDescription() {return description;}

    public String getId() {return id;}

}
