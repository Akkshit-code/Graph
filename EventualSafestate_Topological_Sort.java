import java.util.*;
public class EventualSafestate_Topological_Sort {

        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
            List<List<Integer>> adjRev=new ArrayList<>();
            for(int i=0;i<V;i++){
                adjRev.add(new ArrayList<>());
            }
            int indegree[]=new int[V];
            for(int i=0;i<V;i++){
                for(int it:adj.get(i)){
                    adjRev.get(it).add(i);
                    indegree[i]++;
                }
            }
            Queue<Integer> q=new LinkedList<>();
            List<Integer> safeNodes=new ArrayList<>();
            for(int i=0;i<V;i++){
                if(indegree[i]==0) q.add(i);
            }

            while(!q.isEmpty()){
                int node=q.peek();
                q.remove();
                safeNodes.add(node);
                for(int i:adjRev.get(node)){
                    indegree[i]--;
                    if(indegree[i]==0) q.add(i);
                }
            }

            Collections.sort(safeNodes);
            return safeNodes;

        }
}
