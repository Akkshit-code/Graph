import java.util.*;
class Paaiir{
    int node,distance;
    Paaiir(int distance,int node){
        this.distance=distance;
        this.node=node;
    }
}
public class noofwaystoarriveatdestination {
    public static int numberofpaths(List<List<Integer>> list,int n){
        ArrayList<ArrayList<Paaiir>> adj=new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=list.size();
        for (int i=0;i<m;i++){
            adj.get(list.get(i).get(0)).add(new Paaiir(list.get(i).get(1),list.get(i).get(2)));
            adj.get(list.get(i).get(1)).add(new Paaiir(list.get(i).get(0),list.get(i).get(2)));
        }
        PriorityQueue<Paaiir> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        int [] dist=new int[n];
        int [] ways=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(ways,0);
        dist[0]=0;
        ways[0]=1;
        pq.add(new Paaiir(0,0));
        int mod=(int)(1e9+7);
        while (!pq.isEmpty()){
            int distance=pq.peek().distance;
            int node=pq.peek().node;
            pq.poll();
            for(Paaiir it:adj.get(node)){
                int adjnode=it.distance;
                int edW=it.distance;
                if(distance+edW<dist[adjnode]){
                    dist[adjnode]=distance+edW;
                    pq.add(new Paaiir(distance+edW,adjnode));
                    ways[adjnode]=1;
                }
                else if(distance+edW==dist[adjnode]){
                    ways[adjnode]=(ways[adjnode]+ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(0, 1, 2));
        graph.add(Arrays.asList(0, 2, 4));
        graph.add(Arrays.asList(1, 2, 1));
        graph.add(Arrays.asList(1, 3, 7));
        graph.add(Arrays.asList(2, 3, 3));

        int n = 4; // Number of nodes
        int result = numberofpaths(graph, n);
        System.out.println("Number of ways to arrive at the destination: " + result);
    }

}
