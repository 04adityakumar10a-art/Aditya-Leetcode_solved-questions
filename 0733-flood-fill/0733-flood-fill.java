class Solution {

    public void dfs(int[][] image, int i, int j, int orgclr, int color) {

        int m = image.length;
        int n = image[0].length;

        // boundary + color check
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (image[i][j] != orgclr) return;

        // mark visited
        image[i][j] = color;

        // explore neighbors
        dfs(image, i, j - 1, orgclr, color); // left
        dfs(image, i, j + 1, orgclr, color); // right
        dfs(image, i - 1, j, orgclr, color); // up
        dfs(image, i + 1, j, orgclr, color); // down
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgclr = image[sr][sc];
        if (orgclr == color) return image; // prevent infinite recursion
        dfs(image, sr, sc, orgclr, color);
        return image;
    }
}
