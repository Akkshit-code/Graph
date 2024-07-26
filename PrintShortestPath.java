import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class NodeDistancePair {
    int node;
    int distance;

    public NodeDistancePair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class PrintShortestPath {
    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<NodeDistancePair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new NodeDistancePair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new NodeDistancePair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<NodeDistancePair> pq = new PriorityQueue<NodeDistancePair>((x, y) -> x.distance - y.distance);
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) (1e9);
            parent[i] = i;
        }
        dist[1] = 0;
        pq.add(new NodeDistancePair(1, 0));
        while (pq.size() != 0) {
            NodeDistancePair it = pq.peek();
            int node = it.node;
            int dis = it.distance;
            pq.remove();
            for (NodeDistancePair iter : adj.get(node)) {
                int adjNode = iter.node;
                int edW = iter.distance;
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new NodeDistancePair(adjNode, dis + edW));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dist[n] == 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}