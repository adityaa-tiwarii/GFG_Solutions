//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends




class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int left = 1;
        int right = 1;
        int ans= arr[0];
        
        for(int i=0; i<n; i++){
            if(left ==0){
                left = 1;
            }
            if(right == 0){
                right = 1;
            }
            left *= arr[i];
            right *= arr[n-i-1];
            ans = Math.max(ans, Math.max(left,right));
        }
        return ans;
    }
}