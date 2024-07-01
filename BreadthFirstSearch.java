import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static ArrayList<Integer> BFS(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean [] visited=new boolean[V];
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while (!q.isEmpty()){
            int node= q.poll();
            bfs.add(node);
            for (int it:adj.get(node)){
                if (visited[it]==false){
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;

    }
    public static void main(String[] args) {
        int V = 6;  // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 5);

        // Performing BFS from vertex 0
        ArrayList<Integer> bfsResult = BFS(V, adj);

        // Printing BFS result
        System.out.println("Breadth-First Search starting from vertex 0:");
        for (int node : bfsResult) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    // Helper method to add an undirected edge in the adjacency list
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

}
