package domain.dialog;

import domain.character.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Die Klasse {@code Condition} dient zur Verwaltung von Bedingungen,
 * die über einen {@link domain.character.Character}-Kontext geprüft werden.
 *
 * <p>Sie wird z. B. in {@link domain.dialog.DialogInstance} verwendet, um festzulegen,
 * ob eine Dialogoption verfügbar ist.</p>
 *
 * <p>Intern speichert sie eine Liste von {@code Predicate<Character>} und prüft mit {@code checkAll()},
 * ob alle Bedingungen erfüllt sind. Der zugehörige {@code Character}-Kontext kann gesetzt oder geändert werden.</p>
 *
 * <p>Beispielnutzung:</p>
 * <pre>{@code
 * Condition cond = new Condition(player);
 * cond.addCondition(c -> c.getGuild().equals("Schatten"));
 * if (cond.checkAll()) { ... }
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class Condition {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Condition.class);

    private final List<Predicate<Character>> conditions = new ArrayList<>();
    private Character character; // abgespeicherter Kontext

    public Condition(Character character) {
        this.character = character;
    }

    public Condition() {

    }

    public void addCondition(Predicate<Character> condition) {
    logger.info("addCondition()");        conditions.add(condition);
    }

    public boolean checkAll() {
    logger.info("checkAll()");        if (character == null) return true;
        for (Predicate<Character> condition : conditions) {
            if (!condition.test(character)) {
                return false;
            }
        }
        return true;
    }

    public void setCharacter(Character character) {
    logger.info("setCharacter()");        this.character = character;
    }

    public Character getCharacter() {
    logger.info("getCharacter()");        return character;
    }

    public boolean isEmpty() {
    logger.info("isEmpty()");        return conditions.isEmpty();
    }
}
