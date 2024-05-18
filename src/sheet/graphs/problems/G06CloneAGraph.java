package sheet.graphs.problems;

import java.util.*;

public class G06CloneAGraph {

    public static void main(String[] args) {
        // Example to use this method
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        G06CloneAGraph cloner = new G06CloneAGraph();
        Node clonedGraph = cloner.cloneGraph(node1);

        // printGraph(clonedGraph);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Map to save the cloned nodes
        Map<Node, Node> map = new HashMap<>();

        // Queue for BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        // Clone the root
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            // Iterate through all neighbors
            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone the neighbor and put it in the map
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

