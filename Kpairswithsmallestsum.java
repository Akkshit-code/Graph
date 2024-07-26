import java.util.*;
    class tuples {
        int first,second,sum;
        tuples(int _first, int _second, int _sum){
            this.first=_first;
            this.second=_second;
            this.sum=_sum;
        }
    }
    class Kpairswithsmallestsum {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<tuples> pq=new PriorityQueue<>((a, b)->b.sum-a.sum);
            int n1=nums1.length;
            int n2=nums2.length;
            for(int i=0;i<n1;i++){
                for(int j=0;j<n2;j++){
                    int sum=nums1[i]+nums2[j];
                    if(pq.size()<k){
                        pq.add(new tuples(nums1[i],nums2[j],sum));
                    }
                    else if(sum<pq.peek().sum){
                        pq.poll();
                        pq.add(new tuples(nums1[i],nums2[j],sum));
                    }
                    else break;
                }
            }

            List<List<Integer>> biglist=new ArrayList<>();
            while(!pq.isEmpty()){
                int first=pq.peek().first;
                int second=pq.peek().second;
                pq.remove();
                List<Integer> list=new ArrayList<>();
                list.add(first);
                list.add(second);
                biglist.add(list);
            }
            return biglist;


        }

}
