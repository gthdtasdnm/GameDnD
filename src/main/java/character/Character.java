package character;


public abstract class Character {
    //Unveränderbare Attribute
    protected String name;

    //Veränderbare Attribute
    public CharacterState state;

    public Character(String name, CharacterState state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {return name;}

}

