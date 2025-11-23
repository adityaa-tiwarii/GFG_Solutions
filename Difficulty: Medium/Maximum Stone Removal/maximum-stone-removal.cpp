class Solution {
  public:
  
    int par[1005];
    int rank[1005];
    
    // find absolute parent
    int root(int node) {
        if (par[node]==node) return node;
        
        return par[node] = root(par[node]);
    }
    
    // union the nodes
    void connect(int a, int b) {
        if (par[a]==par[b]) return; // already connected
        
        a = root(a);
        b = root(b);
        
        if (rank[a]<rank[b]) swap(a,b);
        par[b] = a;
        if (rank[a]==rank[b]) rank[a]++;
    }
    
    int maxRemove(vector<vector<int>>& stones) {
        // Code here
        
        int n = stones.size();
        for (int i=0; i<n; i++) {
            par[i]=i;
            rank[i]=0;
        }
        
        if (n==1) return 0;
        
        // key: row no./col no. , value: all the nodes present
        unordered_map<int, vector<int>> row, col;
        
        // create adjacency list from adjacency matrix
        for (int i=0; i<n; i++) {
            row[stones[i][0]].push_back(i);
            col[stones[i][1]].push_back(i);
        }
        
        // connect all nodes present in same row
        for (auto v:row) {
            vector<int> tem = v.second;
            for (int i=1; i<tem.size(); i++) {
                connect(tem[0], tem[i]);
            }
        }
        
        // connect all nodes present in same column
        for (auto v:col) {
            vector<int> tem = v.second;
            for (int i=1; i<tem.size(); i++) {
                connect(tem[0], tem[i]);
            }
        }
        
        set<int> components;
        for (int i=0; i<n; i++) {
            components.insert(root(par[i]));
        }
        
        int ans = n-components.size();
        return ans;
    }
};