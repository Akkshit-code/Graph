import java.util.*;

class Pairs { // Renamed from Pair to Pairs to match your class definition
    int weight, node;
    Pairs(int _weight, int _node) {
        this.weight = _weight;
        this.node = _node;
    }
}

class findthecity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Create adjacency list
        ArrayList<ArrayList<Pairs>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pairs(edge[2], edge[1]));
            adj.get(edge[1]).add(new Pairs(edge[2], edge[0]));
        }

        int val = -1;
        int min = Integer.MAX_VALUE;

        // Perform Dijkstra's algorithm from each city
        for (int i = 0; i < n; i++) {
            PriorityQueue<Pairs> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;
            pq.add(new Pairs(0, i));

            while (!pq.isEmpty()) {
                Pairs current = pq.poll();
                int weigh = current.weight;
                int node = current.node;

                if (weigh > distanceThreshold) break;

                for (Pairs neighbour : adj.get(node)) {
                    int edge = neighbour.weight;
                    int adjnode = neighbour.node;
                    if (weigh + edge < distance[adjnode]) {
                        distance[adjnode] = weigh + edge;
                        pq.add(new Pairs(distance[adjnode], adjnode));
                    }
                }
            }

            int count = 0;
            for (int d : distance) {
                if (d <= distanceThreshold) count++;
            }

            // Update the city with the minimum count of reachable cities
            if (count <= min) {
                min = count;
                val = i;
            }
        }

        return val;
    }
}
