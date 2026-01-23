class Solution {
    public static boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j]) {
                    if(dfs(grid, visited, i, j, -1, -1)) return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(char[][] grid, boolean[][] visited, int row, int col, int prow, int pcol) {
        char ch = grid[row][col];
        visited[row][col] = true;
       //up
        if(row > 0 && grid[row - 1][col] == ch) {
            if(!visited[row - 1][col]) {
                if(dfs(grid, visited, row - 1, col, row, col)) return true;
            }
            else if(row - 1 != prow || col != pcol) return true;
        }
         //down
        if(row < grid.length - 1 && grid[row + 1][col] == ch) {
            if(!visited[row + 1][col]) {
                if(dfs(grid, visited, row + 1, col, row, col)) return true;
            }
            else if(row + 1 != prow || col != pcol) return true;
        }
        //left
        if(col > 0 && grid[row][col - 1] == ch) {
            if(!visited[row][col - 1]) {
                if(dfs(grid, visited, row, col - 1, row, col)) return true;
            }
            else if(row != prow || col - 1 != pcol) return true;
        }
       
        //right
        if(col < grid[0].length - 1 && grid[row][col + 1] == ch) {
            if(!visited[row][col + 1]) {
                if(dfs(grid, visited, row, col + 1, row, col)) return true;
            }
            else if(row != prow || col + 1 != pcol) return true;
        }
        return false;
    }
}