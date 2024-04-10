import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Graph {
    int V;
    ArrayList<Edge> edges;

    public Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    // Find operation for Union-Find algorithm
    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // Union operation for Union-Find algorithm
    void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    // Kruskal's algorithm
    void kruskalMST(int part) {
        ArrayList<Edge> result = new ArrayList<>();
        Collections.sort(edges);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        int edgeCount = 0;
        int index = 0;
        while (edgeCount < V - 1 && index < edges.size()) {
            Edge nextEdge = edges.get(index++);
            int x = find(parent, nextEdge.source);
            int y = find(parent, nextEdge.destination);

            if (x != y && part != 0) {
                result.add(nextEdge);
                union(parent, x, y);
                edgeCount++;
                part--;
            }
        }

        // Print the MST
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : result) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
    }
}

public class NetworkPartition {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        Graph graph = new Graph(V);

        // Add edges to the graph
//        graph.addEdge(1, 2, 4);
//        graph.addEdge(2, 3, 5);
//        graph.addEdge(3, 1, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 2);
        graph.addEdge(1, 3, 4);
        graph.addEdge(3, 4, 3);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 3, 6);

        // Find Minimum Spanning Tree
        graph.kruskalMST(2);


    }
}
