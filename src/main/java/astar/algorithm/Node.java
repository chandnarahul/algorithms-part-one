package astar.algorithm;

public class Node {
    public int gx = 0;
    public int hx = -1;
    public int rowIndex;
    public int colIndex;
    public boolean isBlocked = false;
    public boolean isDiagonal = false;
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
