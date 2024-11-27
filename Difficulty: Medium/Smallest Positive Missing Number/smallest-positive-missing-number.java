//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends








class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
       int n = arr.length;

        // Step 1: Replace negatives, zeros, and numbers larger than n with n + 1
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        // Step 2: Use index marking to identify numbers in the range [1, n]
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val >= 1 && val <= n) {
                if (arr[val - 1] > 0) { // To avoid double marking
                    arr[val - 1] = -arr[val - 1];
                }
            }
        }

        // Step 3: Find the first index that contains a positive number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1; // The first missing positive number is i+1
            }
        }

        // Step 4: If all numbers 1 to n are present, return n + 1
        return n + 1;
    }
}
