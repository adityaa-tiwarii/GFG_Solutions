class Solution {
    //static int maxArea(int mat[][]) {
        // code here
    static int largestRectangle(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!st.isEmpty() && h < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }

   
    static int maxArea(int[][] mat) {
        if (mat.length == 0) return 0;

        int n = mat.length, m = mat[0].length;
        int[] heights = new int[m];  
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
           
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            
            maxArea = Math.max(maxArea, largestRectangle(heights));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] arr1 = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };

        int[][] arr2 = {
            {0, 1, 1},
            {1, 1, 1},
            {0, 1, 1}
        };

        System.out.println(new Solution().maxArea(arr1));
        System.out.println(new Solution().maxArea(arr2)); 
    }
}