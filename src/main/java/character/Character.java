package character;

import item.Item;
import models.Equipment;
import models.Inventory;

import java.util.HashSet;
import java.util.Set;

public abstract class Character {
    //Unveränderbare Attribute
    protected String name;

    //Veränderbare Attribute
    private Set<String> knownInfos = new HashSet<>();
    private String guild;
    protected int maxHp;
    protected int currentHp;
    protected int strength;
    protected int dexterity;
    protected Inventory inventory;
    protected Equipment equipment;

    public Character(String name, String guild, int maxHp, int currentHp,
                     int strength, int dexterity, Inventory inventory, Equipment equipment) {
        this.name = name;
        this.guild = guild;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.inventory = inventory != null ? inventory : new Inventory();
        this.equipment = equipment != null ? equipment : new Equipment();
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

}

