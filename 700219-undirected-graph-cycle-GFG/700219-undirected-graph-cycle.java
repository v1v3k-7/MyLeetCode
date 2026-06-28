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
                if(bfsCycle(i, adjList, visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfsCycle(int src, List<List<Integer>> adjList, boolean[] visited)
    {
        visited[src]=true;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{src, -1});
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0; i<size; i++)
            {
                int[] node=queue.poll(); 
                for(int neighbour: adjList.get(node[0]))
                {
                    if(neighbour==node[1]) continue; //parent ignore
                    if(visited[neighbour]) return true; //pehle hi aa chuka hai mtlb kisi k pass
                    visited[neighbour]=true;
                    queue.offer(new int[]{neighbour, node[0]});
                }
            }
        }
        return false;
    }
}





// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna