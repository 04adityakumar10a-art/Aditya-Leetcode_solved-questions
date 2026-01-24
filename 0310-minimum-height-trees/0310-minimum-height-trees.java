class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);

        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.offer(i);
        }

        int remaining = n;
        while (remaining > 2) {
            int size = q.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int leaf = q.poll();
                for (int nei : graph.get(leaf)) {
                    degree[nei]--;
                    if (degree[nei] == 1) q.offer(nei);
                }
            }
        }

        return new ArrayList<>(q);
    }
}