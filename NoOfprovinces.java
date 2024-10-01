import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class NoOfprovvinces {

    public static void DFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjls, ArrayList<Integer> list) {
        visited[node] = true;
        list.add(node);

        for (int it : adjls.get(node)) {
            if (!visited[it]) {
                DFS(it, visited, adjls, list);
            }
        }
    }

    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        ArrayList<ArrayList<Integer>> adjls = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjls.add(new ArrayList<>());
        }

        // Convert from adjacency matrix to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[V];
        ArrayList<Integer> newlist = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, visited, adjls, newlist);
            }
        }

        return count;
    }
}