class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        
        // Build graph
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        
        // Min-heap (cost, time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        
        pq.offer(new int[]{passingFees[0], 0, 0});
        
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            int cost = curr[0];
            int time = curr[1];
            int node = curr[2];
            
            if(node == n - 1)
                return cost;
            
            if(time >= minTime[node])
                continue;
            
            minTime[node] = time;
            
            for(int[] nei : graph[node]) {
                int nextNode = nei[0];
                int travelTime = nei[1];
                
                int newTime = time + travelTime;
                
                if(newTime <= maxTime) {
                    pq.offer(new int[]{
                        cost + passingFees[nextNode],
                        newTime,
                        nextNode
                    });
                }
            }
        }
        
        return -1;
    }
}