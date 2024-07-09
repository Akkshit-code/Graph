import java.util.ArrayList;

class Solution {
    public boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathvisited) {
        visited[node] = 1;
        pathvisited[node] = 1;
        for (int adjacentnode : adj.get(node)) {
            if (visited[adjacentnode] == 0) {
                if (dfsCheck(adjacentnode, adj, visited, pathvisited) == true) {
                    return true;
                }
            } else if (pathvisited[adjacentnode] == 1) {
                return true;
            }
        }
        pathvisited[node] = 0;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathvisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfsCheck(i, adj, visited, pathvisited) == true) return true;
            }
        }
        return false;
    }
}