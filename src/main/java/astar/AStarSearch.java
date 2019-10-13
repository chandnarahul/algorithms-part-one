package astar;

import astar.algorithm.AStarAlgorithm;
import astar.algorithm.Node;
import astar.algorithm.SearchSpaceAttributes;

import java.util.Optional;

public class AStarSearch {


    public static void main(String[] args) {
        final AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
        final Optional<Node> goalNode = aStarAlgorithm.search(SearchSpaceAttributes.START_NODE);
        if (goalNode.isPresent()) {
            aStarAlgorithm.showPathFrom(goalNode.get());
        } else {
            System.out.println("Unable to find path!");
        }
    }
}
