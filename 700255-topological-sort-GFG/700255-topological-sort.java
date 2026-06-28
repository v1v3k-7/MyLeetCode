class Solution 
{
    public ArrayList<Integer> topoSort(int V, int[][] edges) 
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
            {
                dfsTopoSort(i, visited, st, adj);
            }
        }
        for(int i=0; i<V; i++) res.add(st.pop());
        return res;
    }
    public void dfsTopoSort(int src, boolean[] visited, Stack<Integer> st, List<List<Integer>> adj)
    {
        visited[src]=true;
        for(int neighbour: adj.get(src))
        {
            if(!visited[neighbour])
            {
                dfsTopoSort(neighbour, visited, st, adj);
            }
        }
        st.push(src);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna