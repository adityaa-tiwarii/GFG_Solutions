//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java



//Back-end complete function Template for Java

class Solution {
    public static boolean isValid(int[] arr, int n, int k, int mid){
        int student = 1; 
        int sum = 0; 
        
        for(int i = 0; i<n; i++){
            sum += arr[i];
            
            if(sum > mid){
                student++;
                sum = arr[i];
            }
            if(student > k){
            return false;
            }
        }
        
        return true;
        
    }
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length; 
        int result = -1;
        if(n < k){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0; 
        for(int i = 0; i<n; i++){
            sum += arr[i];
            if(max < arr[i]){
                max = arr[i];
            }
        }
        
        int start = max;
        int end = sum;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(isValid(arr,n,k,mid) == true){
                result = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return result;
    }
}