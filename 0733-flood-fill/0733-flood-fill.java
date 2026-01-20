class Solution {

    static class Pair {
        int row, col;
        Pair(int i, int j) {
            this.row = i;
            this.col = j;
        }
    }

    public static void dfs(int[][] image, int sr, int sc, int orgclr, int color) {

           // prevent infinite loop

        Stack<Pair> st = new Stack<>();
        int m = image.length;
        int n = image[0].length;

        st.push(new Pair(sr, sc));

        while (!st.isEmpty()) {
            Pair val = st.pop();
            int i = val.row;
            int j = val.col;

            if (i < 0 || j < 0 || i >= m || j >= n) continue;
            if (image[i][j] != orgclr) continue;

            // mark visited
            image[i][j] = color;

            // neighbors
            st.push(new Pair(i, j - 1)); // left
            st.push(new Pair(i, j + 1)); // right
            st.push(new Pair(i - 1, j)); // up
            st.push(new Pair(i + 1, j)); // down
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgclr = image[sr][sc];
        if (orgclr == color) return image;
        dfs(image, sr, sc, orgclr, color);
        return image;
    }
}
