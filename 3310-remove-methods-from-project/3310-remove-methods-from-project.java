import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : invocations) {
            graph[e[0]].add(e[1]);
        }

        // Find all suspicious methods
        boolean[] suspicious = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph[u]) {
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    queue.offer(v);
                }
            }
        }

        // Check if any non-suspicious method calls a suspicious one
        for (int[] e : invocations) {
            int u = e[0];
            int v = e[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    res.add(i);
                }
                return res;
            }
        }

        // Remove suspicious methods
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}