import java.util.*;

class Solution {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int primsMST(int V, ArrayList<ArrayList<Pair>> adj) {

        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.weight - b.weight);

        pq.add(new Pair(0, 0));
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int node = curr.node;
            int weight = curr.weight;

            if (visited[node]) continue;

            visited[node] = true;
            mstWeight += weight;

            for (Pair nbr : adj.get(node)) {
                if (!visited[nbr.node]) {
                    pq.add(new Pair(nbr.node, nbr.weight));
                }
            }
        }

        return mstWeight;
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Pair> ls= new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int distance = Math.abs(points[i][0] - points[j][0])
                             + Math.abs(points[i][1] - points[j][1]);

                ls.add(new Pair(j, distance));
            }
            adj.add(ls);
        }

        return primsMST(n, adj);
    }
}