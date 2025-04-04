//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends




class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
          int n = V;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list with the edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean [] visit = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                if(bfs(i,adj,visit,-1)) return true; 
            }
        }
        return false;
    }
    
    public boolean bfs(int s,ArrayList<ArrayList<Integer>> adj,boolean [] visit,int parent){
        visit[s] = true;
        for(int elem:adj.get(s)){
            if(!visit[elem]){
                if(bfs(elem,adj,visit,s)) return true;
            }
            else if(elem!=parent) return true;
        }
        return false;
    }
}