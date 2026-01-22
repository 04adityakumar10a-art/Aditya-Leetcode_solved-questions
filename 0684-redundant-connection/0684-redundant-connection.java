class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];

            // if u and v are already connected, this edge is redundant
            if (dfs(u, v, graph, visited)) {
                return edge;
            }

            // otherwise add edge to graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    private boolean dfs(int src, int target,
                        List<List<Integer>> graph,
                        boolean[] visited) {
        if (src == target) return true;

        visited[src] = true;

        for (int nei : graph.get(src)) {
            if (!visited[nei]) {
                if (dfs(nei, target, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
