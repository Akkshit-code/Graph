import java.util.*;
public class Aliendictionary {
        private List<Integer> toposort(int V,List<List<Integer>> adj){
            int [] indegree=new int[V];
            for (int i=0;i<V;i++){
                for(int adjacentnode:adj.get(i)){
                    indegree[adjacentnode]++;
                }
            }
            Queue<Integer> q=new LinkedList<>();
            for (int i=0;i<V;i++){
                if (indegree[i]==0) q.add(i);
            }
            List<Integer> topo=new ArrayList<>();
            int i=0;
            while (!q.isEmpty()){
                int node=q.peek();
                q.remove();
                topo.add(node);
                // node is in your topo sort
                // so remove it from indegree
                for (int adjacentnode: adj.get(node)){
                    indegree[adjacentnode]--;
                    if (indegree[adjacentnode]==0) q.add(adjacentnode);
                }
            }
            return topo;
        }
        public String findOrder(String [] dict, int N, int K)
        {
            List<List<Integer>> adj=new ArrayList<>();
            for(int i=0;i<=K;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<N-1;i++){
                String s1=dict[i];
                String s2=dict[i+1];
                for(int ptr=0;ptr<Math.min(s1.length(),s2.length());ptr++){
                    if(s1.charAt(ptr)!=s2.charAt(ptr)){
                        adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                        break;
                    }

                }

            }

            List<Integer> list=toposort(K,adj);
            String result="";
            for(int value:list){
                result=result+(char)(value+(int)'a');
            }
            return result;

        }

}
