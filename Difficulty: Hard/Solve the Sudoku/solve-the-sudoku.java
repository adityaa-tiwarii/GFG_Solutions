//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    static void solveSudoku(int[][] mat) {
        solve(0,0,mat);
    }
    static boolean solve(int i,int j,int mat[][]){
        if(j==9){
            i++;
            j=0;
        }
        if(i==9)    return true;
        if(mat[i][j]!=0)    return solve(i,j+1,mat);
        
        for(int x=1;x<=9;x++){
            if(valid(i,j,x,mat)){
                mat[i][j]=x;
                if(solve(i,j+1,mat))    return true;
                mat[i][j]=0;
            }
        }
        return false;
    }
    static boolean valid(int i,int j,int val,int mat[][]){
        //same row
        for(int c=0;c<9;c++){
            if(mat[i][c]==val)  return false;
        }
        //same col
        for(int r=0;r<9;r++){
            if(mat[r][j]==val)  return false;
        }
        //same box
        int si = i/3, sj = j/3;
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                if(mat[si*3+r][sj*3+c]==val)    return false;
            }
        }
        return true;
    }
}