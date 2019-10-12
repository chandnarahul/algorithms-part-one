package astar.algorithm;

public class Heuristics {
    public int manhattanHeuristics(Node currentNode, Node finalNode) {
        return Math.abs(currentNode.colIndex - finalNode.colIndex)
                +
                Math.abs(currentNode.colIndex - finalNode.colIndex);
    }
}
