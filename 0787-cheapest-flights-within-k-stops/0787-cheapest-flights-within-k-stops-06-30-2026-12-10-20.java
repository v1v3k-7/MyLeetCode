class Solution 
{
    //Normal BFS
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] flight: flights)
        {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int[] minPrice=new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        minPrice[src]=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int steps=0;
        while(!queue.isEmpty() && steps<=k)
        {
            int size=queue.size();
            for(int i=0; i<size; i++)
            {
                int[] pair=queue.poll();
                int u=pair[0];
                int d=pair[1];
                // if(d>minPrice[u]) continue;
                for(int[] neighbour: adj.get(u))
                {
                    int v=neighbour[0];
                    int w=neighbour[1];
                    if(d+w < minPrice[v])
                    {
                        minPrice[v]=d+w;
                        queue.offer(new int[]{v, minPrice[v]});
                    }
                }
            }
            steps++;
        }
        return (minPrice[dst]==Integer.MAX_VALUE)?-1:minPrice[dst];
    }
}