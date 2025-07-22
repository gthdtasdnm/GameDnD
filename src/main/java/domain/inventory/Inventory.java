package domain.inventory;

import domain.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Die Klasse {@code Inventory} verwaltet das Inventar eines Charakters.
 *
 * <p>Es enthält eine Sammlung von {@link domain.item.Item}-Objekten, die über ihre ID gespeichert sind,
 * sowie einen Goldzähler für käufliche Transaktionen.</p>
 *
 * <p>Funktionen beinhalten das Hinzufügen, Entfernen und Überprüfen von Items sowie das Verwalten von Gold.</p>
 *
 * <p>Wird typischerweise von {@code PlayerCharacter} oder {@code NPC} verwendet,
 * um Besitzstände im Spiel zu verwalten.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class Inventory {
    protected int gold;
    protected Map<String, Item> inventory;

    public Inventory(){
        gold = 0;
        inventory = new HashMap<>();
    }

    public void addGold(int amount){
        gold += amount;
    }

    public void removeGold(int amount){
        if(gold - amount <= 0){
            System.out.println("nicht genug Gold");
        }else{
            gold -= amount;
        }
    }

    public void addItem(Item item){
        inventory.put(item.getId(),item);
    }

    public boolean hasItem(Item item){
        return inventory.containsKey(item.getId());
    }

    public void removeItem(Item item){
        inventory.remove(item.getId());
    }

    @Override
    public String toString() {
        return inventory.values().stream()
                        .map(Item::getName)
                        .collect(Collectors.joining(", "));
    }





}
