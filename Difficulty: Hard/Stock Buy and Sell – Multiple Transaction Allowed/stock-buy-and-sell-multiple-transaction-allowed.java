//{ Driver Code Starts
// Initial Template for Java.
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int ind,int n,int prices[],int buy,int dp[][]){
        if(ind >=n) return 0;

         //memoization

          if(dp[ind][buy]!=-1) return dp[ind][buy];
        int max = 0;
        if(buy == 1){
            int take = solve(ind+1,n,prices,0,dp)  - prices[ind];
            
            int no_take = solve(ind+1,n,prices,1,dp);
            max = Math.max(max,Math.max(take,no_take));
        }
        else{
            int sale = prices[ind] + solve(ind+1,n,prices,1,dp);
            int no_sale = solve(ind+1,n,prices,0,dp);
            
            max = Math.max(max,Math.max(sale,no_sale));
        }
        
        return dp[ind][buy] = max; //store the calculated value
    }
    public int maximumProfit(int prices[]) {
        // code here
        int n = prices.length;
        int dp[][] = new int[n+1][3];
        
        for(int i = 0; i < n+1; i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(0,n,prices,1,dp);
    }
}