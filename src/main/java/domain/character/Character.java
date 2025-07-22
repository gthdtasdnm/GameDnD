package domain.character;

import domain.item.Armor;
import domain.item.Item;
import domain.inventory.Equipment;
import domain.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

/**
 * Die abstrakte Klasse {@code Character} bildet die gemeinsame Grundlage für alle Spielfiguren.
 *
 * <p>Sie enthält Attribute wie Name, Position, Lebenspunkte, Stärke, Geschicklichkeit sowie
 * Inventar und Ausrüstung.</p>
 *
 * <p>Typische Aktionen sind:</p>
 * <ul>
 *   <li>Schaden nehmen oder heilen</li>
 *   <li>Items aufnehmen, prüfen und ausrüsten</li>
 *   <li>Position verändern (für Kartenbewegung)</li>
 *   <li>Dialoginformationen merken (z. B. Flags für Gesprächsverlauf)</li>
 * </ul>
 *
 * <p>Diese Klasse wird von konkreten Spielcharakteren wie {@code PlayerCharacter} und {@code NPC} erweitert.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public abstract class Character {
    //unchangeable Attribute
    protected String name;
    protected int x;
    protected int y;

    //changeable Attribute
    private String guild;
    protected int maxHp;
    protected int currentHp;
    protected int strength;
    protected int dexterity;

    //Items
    protected Inventory inventory;
    protected Equipment equipment;

    //for dialog flags
    private Set<String> knownInfos = new HashSet<>();

    public Character(String name, String guild, int maxHp,
                     int strength, int dexterity, Inventory inventory, Equipment equipment) {
        this.name = name;
        this.guild = guild;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.inventory = inventory != null ? inventory : new Inventory();
        this.equipment = equipment != null ? equipment : new Equipment();
    }

    public Character() {
        this.name = "Dummy";
        this.guild = "DummyGuild";
        this.maxHp = 100;
        this.currentHp = maxHp;
        this.strength = 10;
        this.dexterity = 10;
        this.inventory = new Inventory();
        this.equipment = new Equipment();
    }

    public void equip(Armor armor){
        if(inventory.hasItem(armor)){
            equipment.equip(armor);
            inventory.removeItem(armor);
        }else{
            System.out.println("item not in inventory");
        }
    }

    public String getName() {return name;}

    public boolean knows(String infoId) {
        return knownInfos.contains(infoId);
    }

    public void learn(String infoId) {
        knownInfos.add(infoId);
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public String getGuild() {
        return guild;
    }

    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public boolean hasItem(Item item) {
        return inventory.hasItem(item);
    }

    public void takeDamage(int amount) {
        currentHp -= amount;
        if(currentHp <= 0){
            System.out.println("You died");
        }
    }

    public void heal(int amount) {
        currentHp += amount;
        if(currentHp > maxHp){
            currentHp = maxHp;
        }
    }

    public int getMaxHp() {return maxHp;}

    public int getDexterity(){return dexterity;}

    public  Inventory getInventory() {return inventory;}

    public Equipment getEquipment() {return equipment;}

    public int getCurrentHp() {return currentHp;}

    public void AddToInventory(Item item){inventory.addItem(item);}

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public String toString(){
        return name;
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }
}

