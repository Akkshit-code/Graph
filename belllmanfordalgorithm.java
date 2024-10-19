import java.util.ArrayList;
import java.util.Arrays;

public class belllmanfordalgorithm {
    public static int[] bellmanford(int V,ArrayList<ArrayList<Integer>> adj,int S){
        int [] dist=new int[V];
        Arrays.fill(dist,(int)(1e8));
        dist[S]=0;
        for (int i=0;i<V;i++){
            for (ArrayList<Integer> it:adj){
                int u=it.get(0);
                int v=it.get(1);
                int w=it.get(2);
                if(dist[u]!=1e8 && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
        for (ArrayList<Integer> it:adj){
            int u=it.get(0);
            int v=it.get(1);
            int w=it.get(2);
            if(dist[u]!=1e8 && dist[u]+w<dist[v]){
                int [] temp=new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dist;
    }
}
