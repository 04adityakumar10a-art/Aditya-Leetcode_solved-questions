class Solution {
    public int[] toposort(int indegree[],ArrayList<ArrayList<Integer>> adj,int n)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        for(int i =0;i<n;i++)
        {
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans.add(node);
            ArrayList<Integer> nbrs = adj.get(node);
            for(int nbr : nbrs)
            {   
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }
        if (ans.size()==n) 
        {  int ans2[] = new int[n];
           for(int i=0 ;i<n;i++)
               {
                ans2[n-i-1]=ans.get(i);
               }
            return ans2;}
        else return new int[0];
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create adjecency list
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        int n= numCourses;
        int indegree[]= new int[n];
        for(int i=0; i<n;i++)
        {
            adj.add(new ArrayList<>());
        } 
        for(int[] graph : prerequisites)
        {
            int node = graph[0];
            int nbr = graph[1];
            indegree[nbr]++;
            adj.get(node).add(nbr);
        }

        return toposort(indegree ,adj,n);

    }
}