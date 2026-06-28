class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) 
    {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[V];
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V; i++)
        {
            if(indegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            res.add(node);
            for(int neighbour: adj.get(node))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0) queue.offer(neighbour);
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna