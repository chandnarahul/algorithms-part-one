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

    public MaizeNode forwardRight() {
        return new MaizeNode(rowIndex + 1, colIndex + 1);
    }

    public MaizeNode forwardLeft() {
        return new MaizeNode(rowIndex + 1, colIndex - 1);
    }

    public MaizeNode back() {
        return new MaizeNode(rowIndex - 1, colIndex);
    }

    public MaizeNode getMovement(RobotMovementSensors robotMovement) {
        if (RobotMovementSensors.FORWARD == robotMovement) {
            return this.forward();
        }
        if (RobotMovementSensors.FORWARD_RIGHT == robotMovement) {
            return this.forwardRight();
        }
        if (RobotMovementSensors.FORWARD_LEFT == robotMovement) {
            return this.forwardLeft();
        }
        if (RobotMovementSensors.LEFT == robotMovement) {
            return this.left();
        }
        if (RobotMovementSensors.RIGHT == robotMovement) {
            return this.right();
        }
        return this.back();
    }
}
