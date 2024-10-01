import java.util.*;
class Debug {
    public static String customSortString(String order, String s) {
        int n1=order.length();
        int n2=s.length();
        int i=0;
        int j=0;
        char [] ch1=order.toCharArray();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int k=0;k<n2;k++){
            if(hm.containsKey(s.charAt(k))){
                hm.put(s.charAt(k),hm.get(s.charAt(k))+1);
            }
            else
                hm.put(s.charAt(k),1);
        }
        char [] ch2=s.toCharArray();
        j = 0;
        while(i<n1 && j<n2){
            if(hm.containsKey(ch1[i])){
                if(ch1[i]!=ch2[j]){
                    if(hm.get(ch1[i])>1) {
                        while (hm.get(ch1[i]) > 0) {
                            ch2[j++] = ch1[i];
                            hm.put(ch1[i], hm.get(ch1[i]) - 1);
                        }
                    }
                    else if(hm.get(ch1[i])<=1){
                        ch2[j]=ch1[i];
                        hm.put(ch1[i], hm.get(ch1[i]) - 1);
                        i++;
                        j++;
                    }
                } else {
                    i++;
                    j++;
                }
            }
        }
        return new String(ch2);
    }

    public static void main(String[] args) {
        System.out.println(customSortString("bcafg","abcd"));
    }
}