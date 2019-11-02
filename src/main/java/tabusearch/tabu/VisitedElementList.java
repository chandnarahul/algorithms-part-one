package tabusearch.tabu;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.Queue;

class VisitedElementList {
    private Queue<Element> visited = new CircularFifoQueue<>();

    boolean contains(Element element) {
        return visited.contains(element);
    }

    void add(Element element) {
        visited.add(element);
    }
}
