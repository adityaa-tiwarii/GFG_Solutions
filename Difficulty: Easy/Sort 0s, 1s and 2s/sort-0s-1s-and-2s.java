//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] a) {
        int zero=0,one=0,two=0,n=a.length;
        for(int it:a){
            if(it==0) zero++;
            else if(it==1) one++;
            else if(it==2) two++;
        }
        int j=0;
        for(int i=0;i<zero;i++) a[j++] =0;
        for(int i=0;i<one;i++) a[j++] =1;
        for(int i=0;i<two;i++) a[j++] =2;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends