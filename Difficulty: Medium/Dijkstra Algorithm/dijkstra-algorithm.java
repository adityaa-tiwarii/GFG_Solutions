//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
        // code here
        class Solution {
    public List<int[]>[] constructAdj(int[][] edges, int V) {

        // Initialize the adjacency list
        List<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        // Fill the adjacency list from edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj[u].add(new int[] {v, wt});
            adj[v].add(new int[] {u, wt});
        }

        return adj;
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Create adjacency list
        List<int[]>[] adj = constructAdj(edges, V);

        // Create a priority queue to store vertices that
        // are being preprocessed.
        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Create a vector for distances and initialize
        // all distances as infinite
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Insert source itself in priority queue and
        // initialize its distance as 0.
        pq.offer(new int[] {0, src});
        dist[src] = 0;

        // Looping till priority queue becomes empty
        // (or all distances are not finalized)
        while (!pq.isEmpty()) {
            // The first vertex in pair is the minimum distance
            // vertex, extract it from priority queue.
            int[] top = pq.poll();
            int u = top[1];

            // Get all adjacent of u.
            for (int[] x : adj[u]) {
                // Get vertex label and weight of current adjacent of u.
                int v = x[0];
                int weight = x[1];

                // If there is shorter path to v through u.
                if (dist[v] > dist[u] + weight) {
                    // Updating distance of v
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[] {dist[v], v});
                }
            }
        }

        return dist;
    }
};
    
