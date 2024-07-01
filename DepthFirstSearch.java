import java.util.ArrayList;

public class DepthFirstSearch {

    public static void dfs(int node, boolean [] visited, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list){
        // Marking the nodes as visited
        visited[node]=true;
        list.add(node);

        // Getting the neighbour nodes
        for (int it:adj.get(node)){
            if (visited[it]==false){
                dfs(it,visited,adj,list);
            }
        }

    }
    public static ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){

        // Boolean array to keep the track of visited vertices
        boolean [] visited=new boolean[V+1];
        visited[0]=true;
        ArrayList<Integer> list=new ArrayList<>();
        dfs(0,visited,adj,list);
        return list;
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
        ArrayList<Integer> bfsResult = dfsOfGraph(V, adj);

        // Printing BFS result
        System.out.println("Depth-First Search starting from vertex 0:");
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

