class Solution {

    List<Integer>[] graph;
    boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int complete = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] info = dfs(i);

                int nodes = info[0];
                int degreeSum = info[1];

                if (degreeSum == nodes * (nodes - 1)) {
                    complete++;
                }
            }
        }

        return complete;
    }

    private int[] dfs(int node) {

        visited[node] = true;

        int nodes = 1;
        int degreeSum = graph[node].size();

        for (int nei : graph[node]) {
            if (!visited[nei]) {
                int[] temp = dfs(nei);
                nodes += temp[0];
                degreeSum += temp[1];
            }
        }

        return new int[]{nodes, degreeSum};
    }
}