class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n]; // memoization
        
        int max = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, dp, i, j));
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j] != 0) return dp[i][j];
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int max = 1; // at least the cell itself
        
        for(int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x >= 0 && y >= 0 && x < m && y < n 
               && matrix[x][y] > matrix[i][j]) {
                
                max = Math.max(max, 1 + dfs(matrix, dp, x, y));
            }
        }
        
        dp[i][j] = max;
        return max;
    }
}