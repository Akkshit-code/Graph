import java.util.ArrayList;
import java.util.HashSet;

public class Noofdistinctislands {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

        private void dfs(int row,int col,int [][] visited,int [][] grid,ArrayList<String> vec,int row0,int col0){
            visited[row][col]=1;
            vec.add(toString(row-row0,col-col0));
            int n=grid.length;
            int m=grid[0].length;
            int [] delrow={-1,0,+1,0};
            int [] delcol={0,-1,0,+1};
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    dfs(nrow,ncol,visited,grid,vec,row0,col0);
                }
            }
        }
        private String toString(int r,int c){
            return Integer.toString(r) + " " + Integer.toString(c);
        }
        int countDistinctIslands(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int [][] visited=new int[n][m];
            HashSet<ArrayList<String>> set=new HashSet<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]==0 && grid[i][j]==1){
                        ArrayList<String> vec=new ArrayList<>();
                        dfs(i,j,visited,grid,vec,i,j);
                        set.add(vec);
                    }
                }
            }
            return set.size();
        }
    }

