package domain.dialog;

public class DialogUtil {
    public static DialogInstance createEndDialog() {
        return new DialogInstance("SYSTEM", "ENDE", new Information());
    }
}
