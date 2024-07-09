import java.util.ArrayList;
import java.util.List;

public class Eventualsafestate {
        private boolean dfsCheck(int node, List<List<Integer>> adj, int[] visited, int[] pathVisited, int[] check) {
            visited[node] = 1;
            pathVisited[node] = 1;
            for (int adjacentNode : adj.get(node)) {
                if (visited[adjacentNode] == 0) {
                    if (dfsCheck(adjacentNode, adj, visited, pathVisited, check)) {
                        return true;
                    }
                } else if (pathVisited[adjacentNode] == 1) {
                    return true;
                }
            }
            check[node] = 1;
            pathVisited[node] = 0;
            return false;
        }

        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
            int[] visited = new int[V];
            int[] pathVisited = new int[V];
            int[] check = new int[V];
            for (int i = 0; i < V; i++) {
                if (visited[i] == 0) {
                    dfsCheck(i, adj, visited, pathVisited, check);
                }
            }
            List<Integer> safeNodes = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                if (check[i] == 1) {
                    safeNodes.add(i);
                }
            }
            return safeNodes;
        }

}
