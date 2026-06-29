class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int dist[]=new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src]=0;
        for(int i=0; i<V; i++)
        {
            boolean isChanged=false;
            for(int[] edge: edges)
            {
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                if(dist[u]!=(int)1e8 && dist[u]+w<dist[v])
                {
                    dist[v]=dist[u]+w;
                    isChanged=true;
                }
            }
            if(!isChanged) break;
        }
        
        for(int[] edge: edges)
        {
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(dist[u]!=(int)1e8 && dist[u]+w<dist[v])
            {
                return new int[]{-1};
                // dist[v]=dist[u]+w;
            }
        }
            
        return dist;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna