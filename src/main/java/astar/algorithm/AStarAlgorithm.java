package astar.algorithm;

import java.util.*;

public class AStarAlgorithm {

    public Optional<Node> search(Node startNode) {
        List<Node> nodesAlreadyVisited = new ArrayList<>();
        Queue<Node> toTraverse = new PriorityQueue<>(new NodeComparator());
        startNode.setHx(new Heuristics().manhattanHeuristics(startNode, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
        toTraverse.add(startNode);
        do {
            Node nodeUnderAnalysis = toTraverse.poll();
            System.out.println(nodeUnderAnalysis);

            if (nodeUnderAnalysis.equals(SearchSpaceAttributes.GOAL_NODE)) {
                return Optional.of(nodeUnderAnalysis);
            } else {
                toTraverse.remove(nodeUnderAnalysis);
                nodesAlreadyVisited.add(nodeUnderAnalysis);

                for (Node neighbour : new NodeNeighbourLocator(nodeUnderAnalysis, nodesAlreadyVisited, toTraverse).getPendingTraversalNeighbours()) {
                    toTraverse.add(neighbour);
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
