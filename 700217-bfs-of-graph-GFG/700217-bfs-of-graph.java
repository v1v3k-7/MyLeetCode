class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) 
    {
        int nodes=adj.size();
        boolean[] visited=new boolean[nodes];
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        queue.offer(0);
        visited[0]=true;
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            res.add(node);
            for(int neighbour: adj.get(node))
            {
                if(!visited[neighbour])
                {
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna