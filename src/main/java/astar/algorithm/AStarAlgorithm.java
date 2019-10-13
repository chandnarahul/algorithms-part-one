package astar.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarAlgorithm {

    public Node search(Node startNode) {
        List<Node> nodesAlreadyVisited = new ArrayList<>();
        Queue<Node> toTraverse = new PriorityQueue<>(new NodeComparator());
        startNode.setHx(new Heuristics().manhattanHeuristics(startNode, SearchSpaceAttributes.GOAL_NODE) * SearchSpaceAttributes.UP_OR_DOWN_MOVE_COST);
        toTraverse.add(startNode);
        do {
            Node nodeUnderAnalysis = toTraverse.poll();
            toTraverse.remove(nodeUnderAnalysis);
            nodesAlreadyVisited.add(nodeUnderAnalysis);

            System.out.println(nodeUnderAnalysis);
            if (nodeUnderAnalysis.equals(SearchSpaceAttributes.GOAL_NODE)) {
                return nodeUnderAnalysis;
            } else {
                for (Node neighbour : new NodeNeighbourLocator(nodeUnderAnalysis, nodesAlreadyVisited, toTraverse).unTraversedNeighbours()) {
                    toTraverse.add(neighbour);
                    neighbour.setChildNode(nodeUnderAnalysis);
                }
            }
        } while (!toTraverse.isEmpty());

        throw new RuntimeException("Unable to find path!");
    }

    public void showPath(Node node) {
        System.out.println("A Star Shortest Path");
        do {
            System.out.println(node);
            node = node.getChildNode();
        } while (node.getChildNode() != null);
        System.out.println(node);
    }
}
