class Solution {
    public static int minCost(int[] arr) {
       if(arr.length==1) return 0;
       
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       int res=0;
       for(int i : arr) pq.offer(i);
       
       while(pq.size()>=2){
           int a=pq.poll(),b=pq.poll();
          
           res+=a+b;
           pq.offer(a+b);
       }
       
       return res;
    }
}

