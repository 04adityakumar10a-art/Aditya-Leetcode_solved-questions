class Solution {
    public int[][] floodFill(int[][] mat, int sr, int sc, int color) {

        int original = mat[sr][sc];
        if (original == color){
            return mat;
        }
        dfs(mat, sr, sc, original, color);
        return mat;
    }

    void dfs(int[][] mat, int i, int j, int original, int color) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return;

        if (mat[i][j] != original)
            return;

        mat[i][j] = color;

        dfs(mat,i+1,j,original,color);
        dfs(mat,i-1,j,original,color);
        dfs(mat,i,j+1,original,color);
        dfs(mat,i,j-1,original,color);
    }
}