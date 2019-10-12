package astar.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarAlgorithm {
    private final Node[][] searchSpace;
    private Node goalNode;
    private List<Node> traversedNodes = new ArrayList<>();
    private Queue<Node> toTraverse = new PriorityQueue<>(new NodeComparator());

    public AStarAlgorithm(Node[][] searchSpace, Node goalNode) {
        this.searchSpace = searchSpace;
        this.goalNode = goalNode;
    }

    public void search(Node startNode) {
        startNode.hx = new Heuristics().manhattanHeuristics(startNode, goalNode) * SearchSpaceDefinition.UP_OR_DOWN_MOVE_COST;
        toTraverse.add(startNode);
        do {
            Node node = toTraverse.poll();
            System.out.println(node);
        } while (!toTraverse.isEmpty());
    }

    public List<Node> neighbours(Node node) {
        List<Node> neighbours = new ArrayList<>();
        //neighbour up
        if (node.rowIndex - 1 <= 0 && searchSpace[node.rowIndex - 1][node.colIndex] == null) {
            neighbours.add(getNeighbourForLocation(node, node.rowIndex - 1, node.colIndex));
        }
        //neighbour down
        if (node.rowIndex + 1 <= SearchSpaceDefinition.NUMBER_OF_ROWS && searchSpace[node.rowIndex + 1][node.colIndex] == null) {
            neighbours.add(getNeighbourForLocation(node, node.rowIndex + 1, node.colIndex));
        }
        //neighbour on left
        if (node.colIndex - 1 <= SearchSpaceDefinition.NUMBER_OF_COLUMNS && searchSpace[node.rowIndex][node.colIndex - 1] == null) {
            neighbours.add(getNeighbourForLocation(node, node.rowIndex, node.colIndex - 1));
        }
        //neighbour on right
        if (node.colIndex + 1 <= SearchSpaceDefinition.NUMBER_OF_COLUMNS && searchSpace[node.rowIndex][node.colIndex + 1] == null) {
            neighbours.add(getNeighbourForLocation(node, node.rowIndex, node.colIndex + 1));
        }
        return neighbours;
    }

    private Node getNeighbourForLocation(Node node, int rowIndex, int i) {
        final Node neighbour = new Node(rowIndex, i);
        neighbour.gx = node.gx + SearchSpaceDefinition.UP_OR_DOWN_MOVE_COST;
        neighbour.hx = new Heuristics().manhattanHeuristics(neighbour, goalNode) * SearchSpaceDefinition.UP_OR_DOWN_MOVE_COST;
        return neighbour;
    }
}
