//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=pat.length();
        for(int i=0;i<=txt.length()-n;i++)
        {   if(pat.charAt(0)!=txt.charAt(i))
            continue;
        String str=txt.substring(i,n+i);
        if(str.equals(pat))
           ans.add(i); }
        return ans;
    }
}