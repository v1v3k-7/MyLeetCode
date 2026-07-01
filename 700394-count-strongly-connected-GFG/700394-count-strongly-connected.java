class Solution 
{
    public void dfs(int src, boolean[] vis, List<List<Integer>> adj, Stack<Integer> stack)
    {
        vis[src]=true;
        for(int neighbour: adj.get(src))
        {
            if(!vis[neighbour])
            {
                dfs(neighbour, vis, adj, stack);
            }
        }
        stack.push(src);
    }
    
    public void dfsCount(int src, boolean[] vis, List<List<Integer>> adj)
    {
        vis[src]=true;
        for(int neighbour: adj.get(src))
        {
            if(!vis[neighbour])
            {
                dfsCount(neighbour, vis, adj);
            }
        }
    }
    
    public int kosaraju(int V, int[][] edges) 
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean vis[]=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs(i, vis, adj, stack);
            }
        }
        //now added in sorting order in stack on the basis of finish time
        //transpose the adj (reverse adj)
        List<List<Integer>> transpose=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            vis[i]=false; //set all visited to false
            transpose.add(new ArrayList<>());
        }
        for(int[] edge: edges)
        {
            transpose.get(edge[1]).add(edge[0]);
        }
        
        int count=0;
        while(!stack.isEmpty())
        {
            int node=stack.pop();
            if(!vis[node])
            {
                count++;
                dfsCount(node, vis, transpose);
            }
        }
        
        return count;
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna