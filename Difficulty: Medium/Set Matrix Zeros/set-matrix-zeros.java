class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        int n = mat.length; int m = mat[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(int r : row){
            for(int j = 0; j < m; j++){
                mat[r][j] = 0;
            }
        }
        
        for(int c : col){
            for(int i = 0; i < n; i++){
                mat[i][c] = 0;
            }
        }
    }
}