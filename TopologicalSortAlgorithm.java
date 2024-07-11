import java.util.*;
class TopologicalSortAlgorithm {
    public static void dfs(int node,int []visited,Stack<Integer> st,ArrayList<ArrayList<Integer>> Biglist){
        visited[node]=1;
        for(int adjacentnode:Biglist.get(node)){
            if(visited[adjacentnode]==0){
                dfs(adjacentnode,visited,st,Biglist);
            }
        }
        st.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int [] visited=new int[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,st,adj);
            }
        }
        int [] result=new int[V];
        int k=0;
        while(!st.isEmpty()){
            result[k++]=st.peek();
            st.pop();
        }
        return result;
    }
}