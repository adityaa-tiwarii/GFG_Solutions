//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(
                    token)); // Use Integer.parseInt to parse int values
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling equilibriumPoint() function
            System.out.println(obj.findEquilibrium(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int findEquilibrium(int arr[]) {
//logic is we have to condtion when leftsum==rightsum
        int totalsum=0;
        int leftsum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            totalsum+=arr[i];
        }
        for(int i=0;i<n;i++){
            totalsum-=arr[i];//leftsum decreasing from totalsum
            if(leftsum==totalsum){
                return i;
            }
            leftsum+=arr[i]; //updating leftsum index wise
        }
     return -1;
   }
}
