import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class tuple{
    int first,second,third;
    tuple(int _first,int _second,int _third){
        this.first=_first;
        this.second=_second;
        this.third=_third;
    }

}
class ShortestdistanceinBinaryMaze {
    public static int shortestPath(int [][] grid,int [] source,int []destination){
        int [][] distance=new int[grid.length][grid[0].length];
        int n=grid.length;
        int m=grid[0].length;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                distance[i][j]=(int)(1e9);
            }
        }
        distance[source[0]][source[1]]=0;
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(0,source[0],source[1]));
        int [] row={-1,0,1,0};
        int [] col={0,1,0,-1};
        while (!q.isEmpty()){
            tuple it=q.peek();
            int dis=it.first;
            int r=it.second;
            int c=it.third;
            for (int i=0;i<4;i++){
                int newr=r+row[i];
                int newc=c+col[i];
                if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1 && dis+1<distance[newr][newc]){
                    distance[newr][newc]=1+dis;
                    if(newr==destination[0] && newc==destination[1]){
                        return dis+1;
                    }
                    q.add(new tuple(dis,newr,newc));
                }
            }

        }
        return -1;


    }
}
