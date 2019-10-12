package astar.algorithm;

public class Heuristics {
    public int manhattanHeuristics(Node currentNode, Node finalNode) {
        return Math.abs(currentNode.getRowIndex() - finalNode.getRowIndex())
                +
                Math.abs(currentNode.getColIndex() - finalNode.getColIndex());
    }
}
