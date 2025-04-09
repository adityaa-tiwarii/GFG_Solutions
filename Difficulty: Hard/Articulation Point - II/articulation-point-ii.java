//{ Driver Code Starts
import java.util.*;

public class Main {
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
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int time = 0;

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] vis, int[] disc, int[] low, int parent, boolean[] ap) {
        vis[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                children++;
                dfs(adj, v, vis, disc, low, u, ap);
                low[u] = Math.min(low[u], low[v]);
                
                if (parent != -1 && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        
        if (parent == -1 && children > 1) {
            ap[u] = true;
        }
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] ap = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, disc, low, -1, ap);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                ans.add(i);
            }
        }
        
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        
        return ans;
    }
}