//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i : arr) pq.offer(i);
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        while(!pq.isEmpty()){
            int a = pq.poll();
            rem += a;
                // System.out.println(rem);
            if(!pq.isEmpty()){
                rem += ( pq.poll());
                if(rem != 0)
                sb.append(rem % 10);
                rem /= 10;
            }
        }
        if(rem != 0) sb.append(rem);
        sb.reverse();
        return sb.toString();
    }
}
