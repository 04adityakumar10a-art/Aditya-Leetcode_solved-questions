class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 = uncolored

        for (int start = 0; start < n; start++) {
            if (color[start] != -1) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            color[start] = 0; // first color

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int nbr : graph[node]) {
                    if (color[nbr] == -1) {
                        color[nbr] = 1 - color[node];
                        q.add(nbr);
                    } 
                    else if (color[nbr] == color[node]) {
                        return false; // conflict found
                    }
                }
            }
        }
        return true;
    }
}
