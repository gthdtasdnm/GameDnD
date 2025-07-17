package Dialog;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Condition<T> {

    private final List<Predicate<T>> conditions = new ArrayList<>();

    public void addCondition(Predicate<T> condition) {
        conditions.add(condition);
    }

    public boolean checkAll(T object) {
        for (Predicate<T> condition : conditions) {
            if (!condition.test(object)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkAny(T object) {
        for (Predicate<T> condition : conditions) {
            if (condition.test(object)) {
                return true;
            }
        }
        return false;
    }
}
