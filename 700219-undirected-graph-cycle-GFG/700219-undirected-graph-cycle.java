class Solution {
    public boolean isCycle(int V, int[][] edges) 
    {
        int nodes=V;
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<nodes; i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[nodes];
        for(int i=0; i<nodes; i++)
        {
            if(!visited[i])
            {
                if(dfsCycle(i, -1, adjList, visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfsCycle(int src, int parent, List<List<Integer>> adjList, boolean[] visited)
    {
        visited[src]=true;
        for(int neighbour: adjList.get(src))
        {
            if(neighbour==parent) continue; //skip parent
            if(visited[neighbour]) return true; //cycle exist
            
            boolean x=dfsCycle(neighbour, src, adjList, visited);
            if(x) return true;
        }
        return false;
    }
}





// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna