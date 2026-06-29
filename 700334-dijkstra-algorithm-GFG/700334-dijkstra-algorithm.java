
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) 
    {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        int[] dist=new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[1], b[1]);
            }
        });
        pq.offer(new int[]{src, 0});
        
        while(!pq.isEmpty())
        {
            int[] pair=pq.poll();
            int u=pair[0];
            int d=pair[1];
            if(d>dist[u]) continue;
            
            for(int[] neighbour: adj.get(u))
            {
                int v=neighbour[0];
                int w=neighbour[1];
                if(dist[u]+w < dist[v]) //Relaxation
                {
                    dist[v]=dist[u]+w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna