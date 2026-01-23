import java.util.*;

class Solution {

    static class State {
        int r, c, pr, pc;
        State(int r, int c, int pr, int pc) {
            this.r = r;
            this.c = c;
            this.pr = pr;
            this.pc = pc;
        }
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (visited[i][j]) continue;

                Queue<State> q = new LinkedList<>();
                q.offer(new State(i, j, -1, -1));
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    State cur = q.poll();

                    for (int[] d : dirs) {
                        int nr = cur.r + d[0];
                        int nc = cur.c + d[1];

                        // boundary check
                        if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                            continue;

                        // same character only
                        if (grid[nr][nc] != grid[cur.r][cur.c])
                            continue;

                        // skip parent
                        if (nr == cur.pr && nc == cur.pc)
                            continue;

                        // visited again → cycle
                        if (visited[nr][nc])
                            return true;

                        visited[nr][nc] = true;
                        q.offer(new State(nr, nc, cur.r, cur.c));
                    }
                }
            }
        }
        return false;
    }
}
