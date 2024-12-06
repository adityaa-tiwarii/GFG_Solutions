//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1]; 

      
        for (int c : citations) {
            if (c >= n) {
                count[n]++; 
            } else {
                count[c]++;
            }
        }

        int hIndex = 0;
        for (int i = n; i >= 0; i--) {
            hIndex += count[i];
            if (hIndex >= i) {
                return i; 
            }
        }

        return 0;
    }
}