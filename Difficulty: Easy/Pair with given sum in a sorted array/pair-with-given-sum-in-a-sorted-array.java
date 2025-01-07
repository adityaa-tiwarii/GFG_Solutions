//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
       int left = 0, right = arr.length-1;
       int count = 0;
       while(left < right){
           int currentSum = arr[left] + arr[right];
           if(currentSum == target){
               int leftValue = arr[left], rightValue = arr[right];
               if(leftValue == rightValue){ 
                   int size = right - left + 1;
                   count+=(size*(size-1))/2;
                   break;
               }
               int leftC = 1, rightC = 1;
               while(right-1 > left && arr[right] == arr[right - 1]){
                   right--;
                   rightC++;
               }
               while(left+1 < right && arr[left] == arr[left + 1]){
                   left++;
                   leftC++;
               }
                count+=leftC*rightC;
                left++;
                right--;
           }else if(currentSum < target){
               left++;
           }else
           right--;
       }
    return count;
    }
}



//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends