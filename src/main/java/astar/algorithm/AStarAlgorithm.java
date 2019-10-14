package astar.algorithm;

import java.util.*;

public class AStarAlgorithm {

    public Optional<Node> search(Node startNode) {
        List<Node> alreadyVisitedNodes = new ArrayList<>();
        List<Node> toTraverse = new ArrayList<>();
        startNode.setHx(new Heuristics().manhattanHeuristics(startNode, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
        toTraverse.add(startNode);
        do {
            Node nodeUnderAnalysis = toTraverse.get(0);

            if (nodeUnderAnalysis.equals(SearchSpaceAttributes.GOAL_NODE)) {
                return Optional.of(nodeUnderAnalysis);
            } else {
                toTraverse.remove(nodeUnderAnalysis);
                alreadyVisitedNodes.add(nodeUnderAnalysis);

                for (Node neighbour : new NodeNeighbourLocator(nodeUnderAnalysis, alreadyVisitedNodes, toTraverse).getPendingTraversalNeighbours()) {
                    toTraverse.add(neighbour);
                    toTraverse.sort(new NodeComparator());
                    neighbour.setPreviousNode(nodeUnderAnalysis);
                }
            }
        } while (!toTraverse.isEmpty());
        return Optional.empty();
    }

    public void showPathFrom(Node node) {
        System.out.println("");
        System.out.println("***********");
        System.out.println("A Star Shortest Path Algorithm");
        System.out.println("***********");
        do {
            System.out.println(node);
            node = node.getPreviousNode();
        } while (node.getPreviousNode() != null);
        System.out.println(node);
    }
}
