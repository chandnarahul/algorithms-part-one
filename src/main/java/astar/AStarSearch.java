package astar;

import astar.algorithm.AStarAlgorithm;
import astar.algorithm.Node;
import astar.algorithm.SearchSpaceAttributes;

public class AStarSearch {


    public static void main(String[] args) {
        final AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
        final Node goalNode = aStarAlgorithm.search(SearchSpaceAttributes.START_NODE);
        aStarAlgorithm.showPathFrom(goalNode);
    }
}
