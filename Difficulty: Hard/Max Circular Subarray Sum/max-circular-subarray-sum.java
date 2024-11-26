//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int maxSum=Integer.MIN_VALUE;
        int currMax=0;
        int minSum=Integer.MAX_VALUE;
        int currMin=0;
        int totalSum=0;
        for(int el : arr){
            currMax=Math.max(currMax+el,el);
            maxSum=Math.max(maxSum,currMax);
            currMin=Math.min(currMin+el,el);
            minSum=Math.min(minSum,currMin);
            totalSum+=el;
        }
        return totalSum==minSum ? maxSum : Math.max(maxSum,totalSum-minSum);
    }
}
