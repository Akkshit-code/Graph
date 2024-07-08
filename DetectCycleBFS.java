//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class DetectCycleBFS{
//class Pair{
//    int first ;
//    int second ;
//    public Pair(int first, int second){
//        this.first= first ;
//        this.second= second ;
//    }
//
//    public boolean detectcycle(int src, ArrayList<ArrayList<Integer>> adj, boolean [] visited){
//        visited[src]=true;
//        Queue<Pair> q=new LinkedList<>();
//        q.add(new Pair(src,-1));
//        while(!q.isEmpty()){
//            int node=q.peek().first;
//            int parent=q.peek().second;
//            q.remove();
//            for(int adjacentNode:adj.get(node)){
//                if(visited[adjacentNode]==false){
//                    visited[adjacentNode]=true;
//                    q.add(new Pair(adjacentNode,node));
//                }
//                else if(parent!=adjacentNode){
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
//    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//        boolean [] visited=new boolean[V];
//        for(int i=0;i<V;i++) visited[i]=false;
//        for(int i=0;i<V;i++){
//            if(visited[i]==false){
//                if(detectcycle(i,adj,visited)) return true;
//            }
//        }
//        return false;
//    }
//}
//
