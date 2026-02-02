class Solution {

    public int[] toposort(int[] indegree, ArrayList<ArrayList<Integer>> adj, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans[idx++] = node;

            for (int nbr : adj.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0)
                    q.add(nbr);
            }
        }

        return (idx == n) ? ans : new int[0];
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }

        return toposort(indegree, adj, numCourses);
    }
}
