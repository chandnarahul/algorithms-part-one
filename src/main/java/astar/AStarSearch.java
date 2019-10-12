package astar;

import astar.algorithm.AStarAlgorithm;
import astar.algorithm.Node;
import astar.algorithm.SearchSpaceDefinition;

public class AStarSearch {


    public static void main(String[] args) {
        Node[][] searchSpace = new Node[SearchSpaceDefinition.NUMBER_OF_ROWS][SearchSpaceDefinition.NUMBER_OF_COLUMNS];

        searchSpace[2][3] = new Node(2, 3, true);
        searchSpace[2][4] = new Node(2, 4, true);
        searchSpace[2][5] = new Node(2, 5, true);
        searchSpace[2][6] = new Node(2, 6, true);
        searchSpace[2][7] = new Node(2, 7, true);
        searchSpace[1][7] = new Node(1, 7, true);

        Node startNode = searchSpace[3][3] = new Node(3, 3);
        Node goalNode = searchSpace[1][6] = new Node(1, 6);

        final AStarAlgorithm aStarAlgorithm = new AStarAlgorithm(searchSpace, goalNode);
        aStarAlgorithm.search(startNode);
    }
}
