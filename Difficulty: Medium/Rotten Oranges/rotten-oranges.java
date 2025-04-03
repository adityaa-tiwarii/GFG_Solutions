//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
  static class Node{
        int row,col;
        public Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] mat) {
        // Code here
        Queue<Node> q=new LinkedList<>();
        int n=mat.length,m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2) q.add(new Node(i,j));
            }
        }
        q.add(null);
        int time=0;
        
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                if(q.isEmpty()) break;
                time++;
                q.add(null);
            } else{
                int row=curr.row;
                int col=curr.col;
                // left
                if(col-1>=0&&mat[row][col-1]==1){
                    mat[row][col-1]=2;
                    q.add(new Node(row,col-1));
                }
                // right
                if(col+1<m&&mat[row][col+1]==1){
                    mat[row][col+1]=2;
                    q.add(new Node(row,col+1));
                }
                // up
                if(row-1>=0&&mat[row-1][col]==1){
                    mat[row-1][col]=2;
                    q.add(new Node(row-1,col));
                }
                
                // down
                if(row+1<n&&mat[row+1][col]==1){
                    mat[row+1][col]=2;
                    q.add(new Node(row+1,col));
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1) return -1;
            }
        }
        
        return time;
    }
}