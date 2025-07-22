package domain.inventory;

/**
 * Das Enum {@code PotionEffect} definiert mögliche Effekte,
 * die ein Trank im Spiel auslösen kann.
 *
 * <p>Derzeit verfügbar:</p>
 * <ul>
 *   <li>{@code HEAL} – Stellt Lebenspunkte wieder her</li>
 * </ul>
 *
 * <p>Wird in {@code Consumable}-Items verwendet, um festzulegen,
 * welche Wirkung beim Konsumieren eintritt.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public enum PotionEffect {
    HEAL
}
