//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        // code here
        int ones = 0, twos = 0;

        for (int num : arr) {
            // Update `ones` with bits that have appeared once
            ones = (ones ^ num) & ~twos;
            
            // Update `twos` with bits that have appeared twice
            twos = (twos ^ num) & ~ones;
        }

        return ones; // Only the number that appeared once will remain in `ones`
    }
}