//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends





class Solution {
    public long subarrayXor(int arr[], int k) {
        // Map to store the prefix XOR and its frequency
        HashMap<Integer, Integer> prefixXorCount = new HashMap<>();
        
        int xor = 0;  // Initialize XOR of elements so far
        long count = 0;  // Initialize count of subarrays
        
        for (int num : arr) {
            xor ^= num;  // Update XOR so far
            
            // If the XOR so far is equal to k, increment the count
            if (xor == k) {
                count++;
            }
            
            // Check if there exists a prefix with XOR `xor ^ k`
            int requiredXor = xor ^ k;
            if (prefixXorCount.containsKey(requiredXor)) {
                count += prefixXorCount.get(requiredXor);
            }
            
            // Add current XOR to the map
            prefixXorCount.put(xor, prefixXorCount.getOrDefault(xor, 0) + 1);
        }
        
        return count;
    }
}
