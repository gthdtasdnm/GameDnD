package DialogTest;

public class DialogLineT {
    private final String speaker;
    private final String listener;
    private final String text;

    public DialogLineT(String speaker, String listener, String text) {
        this.speaker = speaker;
        this.listener = listener;
        this.text = text;
    }

    public void print() {
        System.out.println(speaker + " → " + listener + ": " + text);
    }
}

