//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends






class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
         return kmp(s1+s1,s2);
    }
     static boolean kmp(String txt,String ptr){
        int tn = txt.length(), pn = ptr.length();
        int lps[] = lps(ptr,pn);
        //i for ptr
        int i=0, j=0;
        while(j<tn){
            if(txt.charAt(j)==ptr.charAt(i)){
                i++;
                j++;
            }else{
                if(i==0)    j++;
                else    i=lps[i-1];
            }
            if(i==pn)   return true;
        }
        return false;
    }
    static int[] lps(String s,int n){
        int lps[] = new int[n];
        int i=0, j=1;
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                lps[j]=i;
                j++;
            }else{
                if(i==0)    j++;
                else    i=lps[i-1];
            }
        }
        return lps;
    }
}