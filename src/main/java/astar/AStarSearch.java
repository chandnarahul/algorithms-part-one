package astar;

import astar.algorithm.AStarAlgorithm;
import astar.algorithm.SearchSpaceAttributes;

public class AStarSearch {


    public static void main(String[] args) {
        final AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
        aStarAlgorithm.showPath(aStarAlgorithm.search(SearchSpaceAttributes.START_NODE));
    }
}
