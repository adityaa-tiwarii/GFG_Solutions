class Solution {
    static class Info{
        List<Integer> list;
        int dist;
        public Info(List<Integer> list, int dist){
            this.list = list;
            this.dist = dist;
        }
    }
    public int[] bfs(List<List<Integer>> graph,int source,int V){
        Queue<Info> q = new LinkedList<>();
        int dist = 0, fardestNode = Integer.MIN_VALUE;
        boolean[] visited = new boolean[V];
        visited[source] = true;
        q.add(new Info(graph.get(source), 0));
        
        while(!q.isEmpty()){
            Info curr = q.remove();
            int parDist = curr.dist;
            for(int neighbour:curr.list){
                if(visited[neighbour]) continue;
                dist = parDist+1;
                visited[neighbour] = true;
                fardestNode = neighbour;
                q.add(new Info(graph.get(neighbour), parDist+1));
            }
        }
        
        return new int[]{fardestNode,dist};
    }
    public int diameter(int V, int[][] edges) {
        // Code here
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int src = edge[0];
            int dest = edge[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        
        // choose random u = 0 (let)
        int[] firstNode = bfs(graph,0,V);
        int[] lastNode = bfs(graph,firstNode[0],V);
        
        return lastNode[1];
    }
}

