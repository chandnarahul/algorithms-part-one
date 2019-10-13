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
}
