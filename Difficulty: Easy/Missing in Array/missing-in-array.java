//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().missingNum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



        class Solution {
     public static int missingNum(int arr[]) {
         int n = arr.length + 1; // Since one number is missing
         long total =(long) n * (n + 1) / 2;
         long sum = 0;
    for (int num : arr) {
        sum += num;
    }
    return (int)(total-sum);
    }
    
    public static void main(String[] args){
        int a[]={1,2,3,5};
        System.out.println(missingNum(a));
    }
}
    