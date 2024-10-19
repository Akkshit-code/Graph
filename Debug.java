import java.util.*;
class Pair{
    int first,second,weight;
    Pair(int first,int second,int weight){
        this.first=first;
        this.second=second;
        this.weight=weight;
    }
}
class Debug {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        int [] distance=new int[n];
        for (int i=0;i<n;i++) distance[i]=Integer.MAX_VALUE;
        pq.add(new Pair(0,0,0));
        distance[src]=0;
        while (!pq.isEmpty()){
            Pair node=pq.poll();
            int first=node.first;
            int second=node.second;
            int weight=node.weight;
            if(distance[first]+weight<distance[second]){
                distance[second]=distance[first]+weight;
                if(second==dest) return distance[second];
            }
        }
        return -1;
    }
        public static void main(String[] args) {
            Debug obj = new Debug();

            int n = 4; // Number of cities (nodes)
            int[][] flights = {
                    {0, 1, 100},
                    {1, 2, 100},
                    {0, 2, 500},
                    {2, 3, 100}
            }; // Directed graph with edge weights

            int src = 0; // Source city
            int dest = 3; // Destination city
            int k = 1; // Maximum stops

            int result = obj.findCheapestPrice(n, flights, src, dest, k);
            System.out.println("Cheapest Price: " + result);
        }

}