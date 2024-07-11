import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortAlgorithm_BFS {
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int [] indegree=new int[V];
        for (int i=0;i<V;i++){
            for(int adjacentnode:adj.get(i)){
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<V;i++){
            if (indegree[i]==0) q.add(indegree[i]);
        }
        int [] topo=new int[V];
        int i=0;
        while (!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo[i++]=node;
            // node is in your topo sort
            // so remove it from indegree
            for (int adjacentnode: adj.get(node)){
                indegree[adjacentnode]--;
                if (indegree[adjacentnode]==0) q.add(indegree[adjacentnode]);
            }
        }
        return topo;
    }
}
