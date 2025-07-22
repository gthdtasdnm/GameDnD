package domain.dialog;

import domain.character.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Condition {

    private final List<Predicate<Character>> conditions = new ArrayList<>();
    private Character character; // abgespeicherter Kontext

    public Condition(Character character) {
        this.character = character;
    }

    public Condition() {

    }

    public void addCondition(Predicate<Character> condition) {
        conditions.add(condition);
    }

    public boolean checkAll() {
        if (character == null) return true;
        for (Predicate<Character> condition : conditions) {
            if (!condition.test(character)) {
                return false;
            }
        }
        return true;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public boolean isEmpty() {
        return conditions.isEmpty();
    }
}
