package tabusearch.tabu;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.Queue;

public class VisitedElementList {
    private Queue<Element> visited = new CircularFifoQueue<>();


    public Queue<Element> getVisited() {
        return visited;
    }

    public boolean contains(Element element) {
        return visited.contains(element);
    }
}
