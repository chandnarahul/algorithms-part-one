package graphsearch.astar.algorithm;

public class NodeComparator implements java.util.Comparator<Node> {
    public int compare(Node node1, Node node2) {
        if (node1.fx() < node2.fx()) {
            return -1;
        } else if (node1.fx() > node2.fx()) {
            return 1;
        } else {
            return 0;
        }
    }
}
