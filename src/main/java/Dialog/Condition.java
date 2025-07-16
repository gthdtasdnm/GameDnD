package Dialog;

import character.CharacterState;

@FunctionalInterface
public interface Condition {
    boolean evaluate(CharacterState player);
}
