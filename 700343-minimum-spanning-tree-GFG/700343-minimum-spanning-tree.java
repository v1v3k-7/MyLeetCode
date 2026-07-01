class Solution {
    public int spanningTree(int V, int[][] edges) 
    {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        boolean[] vis=new boolean[V];
        
        int sum=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));
        pq.offer(new int[]{-1, 0, 0}); //[parent, node, weight]
        ArrayList<int[]> res=new ArrayList<>(); //store the edges of MST;
        while(!pq.isEmpty())
        {
            int[] pair=pq.poll();
            int node=pair[1];
            int parent=pair[0];
            int wt=pair[2];
            if(vis[node]) continue;
            vis[node]=true;
            if(parent!=-1)
            {
                res.add(new int[]{parent, node});
                sum+=wt;
            }
            for(int[] neighbour: adj.get(node))
            {
                if(!vis[neighbour[0]])
                {
                    pq.offer(new int[]{node, neighbour[0], neighbour[1]});
                }
            }
        }
        return sum;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna