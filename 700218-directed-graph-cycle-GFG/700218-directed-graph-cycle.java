class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        
        boolean visited[]=new boolean[V];
        boolean pathVisited[]=new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
            {
                if(dfsCycle(i, adj, visited, pathVisited))
                    return true;
            }
            
            
        }
        return false;
    }
    
    public boolean dfsCycle(int src, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited)
    {
        visited[src]=true;
        pathVisited[src]=true;
        for(int neighbour: adj.get(src))
        {
            if(pathVisited[neighbour]) return true;
            else if(visited[neighbour]) continue;
            else
            {
                if(dfsCycle(neighbour, adj, visited, pathVisited)) return true;
            }
        }
        pathVisited[src]=false;
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna