package graphsearch.astar.algorithm;

public class SearchSpaceAttributes {
    public static final int NUMBER_OF_ROWS = 5;
    public static final int NUMBER_OF_COLUMNS = 8;

    public static final int DIAGONAL_MOVE_COST = 14;
    public static final int UP_OR_DOWN_MOVE_COST = 10;
    public static final Node START_NODE = new Node(5, 8);
    public static final Node GOAL_NODE = new Node(1, 6);
    private static final int[][] BLOCKED_NODES_POSITION = {
            {2, 3},
            {2, 4},
            {2, 5},
            {2, 6},
            {2, 7},
            {1, 7}
    };


    private SearchSpaceAttributes() {
    }

    public static boolean nodeIsNotBlocked(int rowIndex, int columnIndex) {
        for (int row = 0; row < SearchSpaceAttributes.BLOCKED_NODES_POSITION.length; row++) {
            for (int col = 0; col < SearchSpaceAttributes.BLOCKED_NODES_POSITION[0].length; col++) {
                if (SearchSpaceAttributes.BLOCKED_NODES_POSITION[row][0] == rowIndex && SearchSpaceAttributes.BLOCKED_NODES_POSITION[row][1] == columnIndex) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }
}
