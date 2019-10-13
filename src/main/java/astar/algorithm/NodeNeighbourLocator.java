package astar.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class NodeNeighbourLocator {
    private final Node currentNode;
    private final List<Node> nodesAlreadyTraversed;
    private final Queue<Node> toTraverse;

    public NodeNeighbourLocator(Node currentNode, List<Node> nodesAlreadyTraversed, Queue<Node> toTraverse) {
        this.currentNode = currentNode;
        this.nodesAlreadyTraversed = nodesAlreadyTraversed;
        this.toTraverse = toTraverse;
    }

    private Optional<Node> getNeighbourForLocation(int rowIndex, int columnIndex, boolean diagonal) {
        final Node neighbour = new Node(rowIndex, columnIndex, diagonal);
        if (SearchSpaceAttributes.nodeIsNotBlocked(rowIndex, columnIndex) && !nodesAlreadyTraversed.contains(neighbour) && !toTraverse.contains(neighbour)) {
            if (diagonal) {
                neighbour.setGx(currentNode.getGx() + SearchSpaceAttributes.DIAGONAL_MOVE_COST);
                neighbour.setHx(new Heuristics().manhattanHeuristics(neighbour, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.DIAGONAL_MOVE_COST);
            } else {
                neighbour.setGx(currentNode.getGx() + SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
                neighbour.setHx(new Heuristics().manhattanHeuristics(neighbour, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
            }
            return Optional.of(neighbour);
        } else {
            return Optional.empty();
        }
    }

    public List<Node> unTraversedNeighbours() {
        List<Node> neighbours = new ArrayList<>();
        //neighbour up
        if (currentNode.getRowIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(currentNode.getRowIndex() - 1, currentNode.getColIndex())) {
            final Optional<Node> neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() - 1, currentNode.getColIndex(), false);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour down
        if (currentNode.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS) {
            final Optional<Node> neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() + 1, currentNode.getColIndex(), false);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour on left
        if (currentNode.getColIndex() - 1 >= 0) {
            final Optional<Node> neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex(), currentNode.getColIndex() - 1, false);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour on right
        if (currentNode.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS) {
            final Optional<Node> neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex(), currentNode.getColIndex() + 1, false);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour on diagonal up right
        if (currentNode.getColIndex() - 1 >= 0 && currentNode.getRowIndex() - 1 >= 0) {
            final Optional<Node> neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() - 1, currentNode.getColIndex() - 1, Boolean.TRUE);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour on diagonal up left
        if (currentNode.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS && currentNode.getRowIndex() - 1 >= 0) {
            final Optional<Node> neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() - 1, currentNode.getColIndex() + 1, Boolean.TRUE);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour on diagonal down right
        if (currentNode.getColIndex() - 1 >= 0 && currentNode.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS) {
            final Optional<Node> neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() + 1, currentNode.getColIndex() - 1, Boolean.TRUE);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }

        //neighbour on diagonal down left
        if (currentNode.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS && currentNode.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS) {
            final Optional<Node> neighbourForLocation = getNeighbourForLocation(currentNode.getRowIndex() + 1, currentNode.getColIndex() + 1, Boolean.TRUE);
            if (neighbourForLocation.isPresent()) {
                neighbours.add(neighbourForLocation.get());
            }
        }
        return neighbours;
    }
}
