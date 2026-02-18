class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] f : flights) {
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }

        // {node, cost, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.offer(new int[]{src, 0, 0});

        // distance[node][stops] = min cost
        int[][] dist = new int[n][K + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (node == dst)
                return cost;

            if (stops <= K) {
                if (!graph.containsKey(node))
                    continue;

                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int price = neighbor[1];

                    int newCost = cost + price;

                    if (newCost < dist[nextNode][stops + 1]) {
                        dist[nextNode][stops + 1] = newCost;
                        pq.offer(new int[]{nextNode, newCost, stops + 1});
                    }
                }
            }
        }

        return -1;
    }
}
