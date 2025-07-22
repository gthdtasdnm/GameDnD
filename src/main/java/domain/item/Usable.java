package domain.item;

/**
 * Das Interface {@code Usable} definiert ein Verhalten für Gegenstände,
 * die auf einen {@link domain.character.Character} angewendet werden können.
 *
 * <p>Typische Implementierungen sind z. B. {@link Consumable}-Items wie Heiltränke.</p>
 *
 * <p>Die Methode {@code use()} wird aufgerufen, wenn das Item verwendet wird.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public interface Usable {
    void use(Character character);
}
