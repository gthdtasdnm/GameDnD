package DialogTest;

import java.util.LinkedList;
import java.util.Queue;

public class DialogEngineT {
    private final Queue<DialogLineT> queue = new LinkedList<>();

    public void queueLine(String speaker, String listener, String text) {
        queue.add(new DialogLineT(speaker, listener, text));
    }

    public void run() {
        while (!queue.isEmpty()) {
            queue.poll().print();
        }
    }
}
