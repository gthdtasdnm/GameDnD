package character;

public class NPC extends Character{
    //Quest die der NPC dir gibt
    protected QuestLog questlog;

    public NPC(String id, String name, int maxHp) {
        super(id, name, maxHp);
    }

    public String getId() {return id;}
}
