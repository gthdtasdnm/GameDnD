package domain.dialog;

import java.util.LinkedList;
import java.util.Queue;

public class Information {
    private Queue<InfoElement> elements = new LinkedList<>();

    public void add(InfoElement element) {
        elements.offer(element);
    }

    public void processAll() {
        while (!elements.isEmpty()) {
            InfoElement next = elements.poll();
            next.execute();
        }
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
