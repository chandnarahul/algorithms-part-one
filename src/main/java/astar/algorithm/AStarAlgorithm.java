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
        startNode.setHx(new Heuristics().manhattanHeuristics(startNode, goalNode) * SearchSpaceDefinition.UP_OR_DOWN_MOVE_COST);
        toTraverse.add(startNode);
        do {
            Node node = toTraverse.poll();
            System.out.println(node);
        } while (!toTraverse.isEmpty());
    }

    public List<Node> neighbours(Node node) {
        List<Node> neighbours = new ArrayList<>();
        //neighbour up
        if (node.getRowIndex() - 1 <= 0 && searchSpace[node.getRowIndex() - 1][node.getColIndex()] == null) {
            neighbours.add(getNeighbourForLocation(node, node.getRowIndex() - 1, node.getColIndex()));
        }
        //neighbour down
        if (node.getRowIndex() + 1 <= SearchSpaceDefinition.NUMBER_OF_ROWS && searchSpace[node.getRowIndex() + 1][node.getColIndex()] == null) {
            neighbours.add(getNeighbourForLocation(node, node.getRowIndex() + 1, node.getColIndex()));
        }
        //neighbour on left
        if (node.getColIndex() - 1 <= SearchSpaceDefinition.NUMBER_OF_COLUMNS && searchSpace[node.getRowIndex()][node.getColIndex() - 1] == null) {
            neighbours.add(getNeighbourForLocation(node, node.getRowIndex(), node.getColIndex() - 1));
        }
        //neighbour on right
        if (node.getColIndex() + 1 <= SearchSpaceDefinition.NUMBER_OF_COLUMNS && searchSpace[node.getRowIndex()][node.getColIndex() + 1] == null) {
            neighbours.add(getNeighbourForLocation(node, node.getRowIndex(), node.getColIndex() + 1));
        }
        return neighbours;
    }

    private Node getNeighbourForLocation(Node node, int rowIndex, int i) {
        final Node neighbour = new Node(rowIndex, i);
        neighbour.setGx(node.getGx() + SearchSpaceDefinition.UP_OR_DOWN_MOVE_COST);
        neighbour.setHx(new Heuristics().manhattanHeuristics(neighbour, goalNode) * SearchSpaceDefinition.UP_OR_DOWN_MOVE_COST);
        return neighbour;
    }
}
