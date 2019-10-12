package astar.algorithm;

public class Node {
    private int gx = 0;
    private int hx = -1;
    private int rowIndex;
    private int colIndex;
    private boolean isBlocked = false;
    private boolean isDiagonal = false;
    private Node parentNode = null;

    public Node(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public Node(int rowIndex, int colIndex, boolean isBlocked) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.isBlocked = isBlocked;
    }

    public Node(int rowIndex, int colIndex, boolean isBlocked, boolean isDiagonal) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.isBlocked = isBlocked;
        this.isDiagonal = isDiagonal;
    }

    public int fx() {
        return gx + hx;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
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
                ", isBlocked=" + isBlocked +
                ", isDiagonal=" + isDiagonal +
                ", parentNode= {" + ((parentNode != null) ? (+parentNode.rowIndex + ", " + parentNode.colIndex) : "null") + "}" +
                '}';
    }
}
