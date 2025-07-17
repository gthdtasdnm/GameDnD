package Dialog;

@FunctionalInterface
public interface Condition {
    boolean evaluate(CharacterState player);
}
