class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int MOD = 1_000_000_007;
        
        // Step 1: Build Graph
        List<List<long[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            
            adj.get(u).add(new long[]{v, time});
            adj.get(v).add(new long[]{u, time});
        }
        
        // Step 2: Dijkstra Setup
        long[] dist = new long[n];
        long[] ways = new long[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        
        pq.offer(new long[]{0, 0}); // {distance, node}
        
        while(!pq.isEmpty()) {
            
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];
            
            if(d > dist[node]) continue;
            
            for(long[] neighbor : adj.get(node)) {
                int next = (int) neighbor[0];
                long time = neighbor[1];
                
                // Case 1: Found shorter path
                if(dist[next] > d + time) {
                    dist[next] = d + time;
                    ways[next] = ways[node];
                    pq.offer(new long[]{dist[next], next});
                }
                
                // Case 2: Found another shortest path
                else if(dist[next] == d + time) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }
        
        return (int)(ways[n - 1] % MOD);
    }
}