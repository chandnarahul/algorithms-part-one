package tune_robot_sensors_using_genetic_algorithm;

public class MaizeNode {
    private int rowIndex;
    private int colIndex;

    public MaizeNode(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public String toString() {
        return "Node {" +
                "rowIndex=" + rowIndex +
                ", colIndex=" + colIndex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return Boolean.TRUE;
        if (o == null || getClass() != o.getClass()) return false;

        MaizeNode node = (MaizeNode) o;

        if (getRowIndex() != node.getRowIndex()) return false;
        return getColIndex() == node.getColIndex();
    }

    @Override
    public int hashCode() {
        return 31 * getRowIndex() + getColIndex();
    }

    public MaizeNode forward() {
        return new MaizeNode(rowIndex + 1, colIndex);
    }

    public MaizeNode left() {
        return new MaizeNode(rowIndex, colIndex - 1);
    }

    public MaizeNode right() {
        return new MaizeNode(rowIndex, colIndex + 1);
    }

    public MaizeNode back() {
        return new MaizeNode(rowIndex - 1, colIndex);
    }

    public MaizeNode getMovement(RobotMovement robotMovement) {
        if (RobotMovement.FORWARD == robotMovement) {
            return this.forward();
        }
        if (RobotMovement.LEFT == robotMovement) {
            return this.left();
        }
        if (RobotMovement.RIGHT == robotMovement) {
            return this.right();
        }
        return this.back();
    }
}
