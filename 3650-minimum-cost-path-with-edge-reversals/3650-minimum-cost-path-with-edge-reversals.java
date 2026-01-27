class Solution {
    static class Pair {
        int node, distance;
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int dijkstra(int V, ArrayList<List<Pair>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.distance - b.distance);

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.distance;

            if (d > dist[node]) continue;

            for (Pair nbr : adj.get(node)) {
                int next = nbr.node;
                int weight = nbr.distance;

                if (dist[node] != Integer.MAX_VALUE &&
                    dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.add(new Pair(next, dist[next]));
                }
            }
        }
        return dist[V-1] == Integer.MAX_VALUE ? -1 : dist[V-1];
    }

    public int minCost(int n, int[][] edges) {
        ArrayList<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], 2 * edges[i][2]));
        }

        return dijkstra(n, adj, 0); // correct source
    }
}