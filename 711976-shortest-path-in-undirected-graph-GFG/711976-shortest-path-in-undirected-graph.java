class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) 
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] res=new int[V];
        Arrays.fill(res, -1);
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(src);
        boolean[] visited=new boolean[V];
        visited[src]=true;
        int level=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0; i<size; i++)
            {
                int node=queue.poll();
                res[node]=level;
                for(int neighbour: adj.get(node))
                {
                    if(!visited[neighbour])
                        queue.offer(neighbour);
                        visited[neighbour]=true;
                }
            }
            level++;
        }
        return res;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna