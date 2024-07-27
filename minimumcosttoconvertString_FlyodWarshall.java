public class minimumcosttoconvertString_FlyodWarshall {
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            int [][] matrix=new int[26][26];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
            for(int i=0;i<matrix.length;i++) matrix[i][i]=0;
            for(int i=0;i<cost.length;i++){
                matrix[original[i]-'a'][changed[i]-'a']=Math.min( matrix[original[i]-'a'][changed[i]-'a'],cost[i]);
            }
            int n=matrix.length;
            for(int k=0;k<n;k++){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(matrix[i][k]==Integer.MAX_VALUE || matrix[k][j]==Integer.MAX_VALUE){
                            continue;
                        }
                        else{
                            matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                        }
                    }
                }
            }

            long costs=0;
            for(int i=0;i<source.length();i++){
                if(matrix[source.charAt(i)-'a'][target.charAt(i)-'a']==Integer.MAX_VALUE){
                    return -1;
                }
                costs+=matrix[source.charAt(i)-'a'][target.charAt(i)-'a'];
            }
            if(costs==Integer.MAX_VALUE) return -1;
            else return costs;



        }

}
