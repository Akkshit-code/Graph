import java.util.*;

class ShortestRoutes {

    static class Pair {
        long distance;
        int node;

        public Pair(long distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static long[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Long.compare(x.distance, y.distance));
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE); // Initially, all distances are infinity
        dist[S] = 0;  // Distance to the source is 0
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long currentDist = current.distance;
            int node = current.node;

            // Skip processing if we have found a shorter path already
            if (currentDist > dist[node]) continue;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                long edgeWeight = neighbor.distance;

                if (currentDist + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = currentDist + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes and edges
        int n = sc.nextInt(); // Number of nodes
        int m = sc.nextInt(); // Number of edges

        // Create the adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1; // 1-based to 0-based index
            int v = sc.nextInt() - 1; // 1-based to 0-based index
            long w = sc.nextLong(); // Weight of the edge (note: use nextLong!)
            adj.get(u).add(new Pair(w, v)); // Directed edge u -> v
        }

        // Start the Dijkstra algorithm from node 1 (index 0 in 0-based)
        long[] distances = dijkstra(n, adj, 0);

        // Print the distances from node 1 to all other nodes
        for (int i = 0; i < n; i++) {
            if (distances[i] == Long.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(distances[i] + " ");
            }
        }
        System.out.println();
    }
}
