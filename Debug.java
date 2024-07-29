import java.util.*;
class Debug {
    public static int longestContinuousSubstring(String s) {
        int n=s.length();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            int val=i;
            int count=1;
            while(val<n-1 && s.charAt(val+1)-s.charAt(val)==1){
                count++;
                val++;
            }
            if(count>max) max=count;
        }
        return max;
    }

        public static void main(String[] args) {
            System.out.println(longestContinuousSubstring("abacaba"));
        }
}