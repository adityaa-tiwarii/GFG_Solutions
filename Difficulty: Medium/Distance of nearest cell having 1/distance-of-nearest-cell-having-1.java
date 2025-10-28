class Solution {
    static class Info{
        int row,col,distance;
        public Info(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        Info[][] info = new Info[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) {
                    q.add(new int[]{i,j});
                    info[i][j] = new Info(i,j,0);
                } else {
                    info[i][j] = new Info(i,j,Integer.MAX_VALUE);
                }
            }
        }
        
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {
                                {1, 0},  // down
                                {-1, 0}, // up
                                {0, 1},  // right
                                {0, -1}, // left
                                {1, 1},  // down-right
                                {1, -1}, // down-left
                                {-1, 1}, // up-right
                                {-1, -1} // up-left
                             };
                             
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            for(int[] dir:directions){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                    int distance = Math.abs(row-newRow)+Math.abs(col-newCol)+info[row][col].distance;
                    if(info[newRow][newCol].distance>distance) {
                        info[newRow][newCol].distance = distance;
                        q.add(new int[]{newRow,newCol});
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<m;j++){
                list.add(info[i][j].distance);
            }
            ans.add(list);
        }
        
        return ans;
    }
}