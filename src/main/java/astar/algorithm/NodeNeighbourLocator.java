package astar.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NodeNeighbourLocator {
    private Node currentNode;

    public NodeNeighbourLocator(Node currentNode) {
        this.currentNode = currentNode;
    }

    private Node getNeighbourForLocation(int rowIndex, int columnIndex, boolean diagonal) {
        final Node neighbour = new Node(rowIndex, columnIndex, diagonal);
        if (diagonal) {
            neighbour.setGx(currentNode.getGx() + SearchSpaceAttributes.DIAGONAL_MOVE_COST);
            neighbour.setHx(new Heuristics().manhattanHeuristics(neighbour, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.DIAGONAL_MOVE_COST);
        } else {
            neighbour.setGx(currentNode.getGx() + SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
            neighbour.setHx(new Heuristics().manhattanHeuristics(neighbour, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
        }
        return neighbour;
    }

    public List<Node> unTraversedNeighbours(List<Node> nodesAlreadyTraversed) {
        List<Node> neighbours = new ArrayList<>();
        //neighbour up
        if (currentNode.getRowIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex() - 1, currentNode.getColIndex())) {
            final Node neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() - 1, currentNode.getColIndex(), false);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour down
        if (currentNode.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex() + 1, currentNode.getColIndex())) {
            final Node neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() + 1, currentNode.getColIndex(), false);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on left
        if (currentNode.getColIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex(), currentNode.getColIndex() - 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex(), currentNode.getColIndex() - 1, false);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on right
        if (currentNode.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex(), currentNode.getColIndex() + 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex(), currentNode.getColIndex() + 1, false);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on diagonal up right
        if (currentNode.getColIndex() - 1 >= 0 && currentNode.getRowIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex() - 1, currentNode.getColIndex() - 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() - 1, currentNode.getColIndex() - 1, Boolean.TRUE);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on diagonal up left
        if (currentNode.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS && currentNode.getRowIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex() - 1, currentNode.getColIndex() + 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() - 1, currentNode.getColIndex() + 1, Boolean.TRUE);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on diagonal down right
        if (currentNode.getColIndex() - 1 >= 0 && currentNode.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex() + 1, currentNode.getColIndex() - 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() + 1, currentNode.getColIndex() - 1, Boolean.TRUE);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on diagonal down left
        if (currentNode.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS && currentNode.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex() + 1, currentNode.getColIndex() + 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() + 1, currentNode.getColIndex() + 1, Boolean.TRUE);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }
        return neighbours;
    }
}
