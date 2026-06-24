class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) 
    {
        int nodes=adj.size();
        ArrayList<Integer> res=new ArrayList<>();
        boolean[] visited=new boolean[nodes]; //node 0, ....., node nodes-1;
        for(int i=0; i<nodes; i++)
        {
            if(!visited[i])
            {
                dfs(i, visited, adj, res);
            }
        }
        return res;
    }
    public void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res)
    {
        visited[node]=true;
        res.add(node);
        for(int neighbour: adj.get(node))
        {
            if(!visited[neighbour])
            {
                dfs(neighbour, visited, adj, res);
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna