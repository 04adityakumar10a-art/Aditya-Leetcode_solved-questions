import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int INF = (int) 1e9;
        int[][] dist = new int[n][n];

        //  Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        //  Fill direct edges
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        //  Floyd–Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Find city with minimum reachable neighbors
        int resultCity = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // Tie-breaking: choose city with larger index
            if (count <= minCount) {
                minCount = count;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
