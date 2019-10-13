package astar.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int gx = 0;
    private int hx = -1;
    private int rowIndex;
    private int colIndex;
    private boolean isDiagonal = false;
    private Node childNode = null;

    public Node(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public Node(int rowIndex, int colIndex, boolean isDiagonal) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.isDiagonal = isDiagonal;
    }

    public int fx() {
        return gx + hx;
    }

    public Node getChildNode() {
        return childNode;
    }

    public void setChildNode(Node childNode) {
        this.childNode = childNode;
    }

    public void setHx(int hx) {
        this.hx = hx;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public int getGx() {
        return gx;
    }

    public void setGx(int gx) {
        this.gx = gx;
    }

    @Override
    public String toString() {
        return "Node {" +
                "rowIndex=" + rowIndex +
                ", colIndex=" + colIndex +
                ", gx=" + gx +
                ", hx=" + hx +
                ", fx=" + fx() +
                ", isDiagonal=" + isDiagonal +
                ", childNode= {" + ((childNode != null) ? (+childNode.rowIndex + ", " + childNode.colIndex) : "null") + "}" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return Boolean.TRUE;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (getRowIndex() != node.getRowIndex()) return false;
        return getColIndex() == node.getColIndex();
    }

    @Override
    public int hashCode() {
        return 31 * getRowIndex() + getColIndex();
    }

    private Node getNeighbourForLocation(int rowIndex, int columnIndex, boolean diagonal) {
        final Node neighbour = new Node(rowIndex, columnIndex, diagonal);
        if (diagonal) {
            neighbour.setGx(this.getGx() + SearchSpaceAttributes.DIAGONAL_MOVE_COST);
            neighbour.setHx(new Heuristics().manhattanHeuristics(neighbour, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.DIAGONAL_MOVE_COST);
        } else {
            neighbour.setGx(this.getGx() + SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
            neighbour.setHx(new Heuristics().manhattanHeuristics(neighbour, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
        }
        return neighbour;
    }

    public List<Node> unTraversedNeighbours(List<Node> nodesAlreadyTraversed) {
        List<Node> neighbours = new ArrayList<>();
        //neighbour up
        if (this.getRowIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(this.getRowIndex() - 1, this.getColIndex())) {
            final Node neighbourForLocation = getNeighbourForLocation(this.getRowIndex() - 1, this.getColIndex(), false);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour down
        if (this.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS && SearchSpaceAttributes.nodeIsNotBlocked(this.getRowIndex() + 1, this.getColIndex())) {
            final Node neighbourForLocation = getNeighbourForLocation(this.getRowIndex() + 1, this.getColIndex(), false);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on left
        if (this.getColIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(this.getRowIndex(), this.getColIndex() - 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(this.getRowIndex(), this.getColIndex() - 1, false);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on right
        if (this.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS && SearchSpaceAttributes.nodeIsNotBlocked(this.getRowIndex(), this.getColIndex() + 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(this.getRowIndex(), this.getColIndex() + 1, false);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on diagonal up right
        if (this.getColIndex() - 1 >= 0 && this.getRowIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(this.getRowIndex() - 1, this.getColIndex() - 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(this.getRowIndex() - 1, this.getColIndex() - 1, Boolean.TRUE);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on diagonal up left
        if (this.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS && this.getRowIndex() - 1 >= 0 && SearchSpaceAttributes.nodeIsNotBlocked(this.getRowIndex() - 1, this.getColIndex() + 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(this.getRowIndex() - 1, this.getColIndex() + 1, Boolean.TRUE);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on diagonal down right
        if (this.getColIndex() - 1 >= 0 && this.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS && SearchSpaceAttributes.nodeIsNotBlocked(this.getRowIndex() + 1, this.getColIndex() - 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(this.getRowIndex() + 1, this.getColIndex() - 1, Boolean.TRUE);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }

        //neighbour on diagonal down left
        if (this.getColIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_COLUMNS && this.getRowIndex() + 1 < SearchSpaceAttributes.NUMBER_OF_ROWS && SearchSpaceAttributes.nodeIsNotBlocked(this.getRowIndex() + 1, this.getColIndex() + 1)) {
            final Node neighbourForLocation = getNeighbourForLocation(this.getRowIndex() + 1, this.getColIndex() + 1, Boolean.TRUE);
            if (!nodesAlreadyTraversed.contains(neighbourForLocation)) {
                neighbours.add(neighbourForLocation);
            }
        }
        return neighbours;
    }

}
