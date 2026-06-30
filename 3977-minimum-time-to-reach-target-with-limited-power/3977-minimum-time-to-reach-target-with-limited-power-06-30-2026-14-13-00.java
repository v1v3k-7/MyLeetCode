class Solution 
{
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) 
    {
        List<List<int[]>> adj=new ArrayList<>(); //index -> v, w 
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges)
        {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        Long INF=Long.MAX_VALUE;
        long[][] dist=new long[n][power+1];
        for(long[] row: dist) Arrays.fill(row, INF);
        dist[source][power]=0;

        //[node, timeFromSource, power]
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
        pq.offer(new long[]{source, 0, power});
        while(!pq.isEmpty())
        {
            long[] cur=pq.poll();
            int u=(int) cur[0];
            long t=cur[1];
            int p=(int) cur[2];

            if(t>dist[u][p]) continue;
            if(p<cost[u]) continue;

            int newP=p-cost[u];
            for(int[] neighbour: adj.get(u))
            {
                int v=neighbour[0];
                int w=neighbour[1];
                long d=t+w;
                if(d<dist[v][newP])
                {
                    dist[v][newP]=d;
                    pq.offer(new long[]{v, dist[v][newP], newP});
                }
            }
        }
        long bestTime=INF;
        long bestPower=-1;
        for(int p=0; p<=power; p++)
        {
            long d=dist[target][p];
            if(d<bestTime)
            {
                bestTime=d;
                bestPower=p;
            }
            else if(d==bestTime && bestTime!=INF)
            {
                bestPower=Math.max(bestPower, p);
            }
        }

        if(bestTime==INF) return new long[]{-1, -1};
        else return new long[]{bestTime, bestPower};
    }
}