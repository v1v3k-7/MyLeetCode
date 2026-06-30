class State implements Comparable<State>
{
    long time;
    int node;
    int power;

    State(int node, long time, int power) {
        this.time = time;
        this.node = node;
        this.power = power;
    }
    @Override
    public int compareTo(State that)
    {
        return Long.compare(this.time, that.time);
    }
}

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
        PriorityQueue<State> pq=new PriorityQueue<>();
        pq.offer(new State(source, 0L, power));
        while(!pq.isEmpty())
        {
            State cur=pq.poll();
            int u=cur.node;
            long t=cur.time;
            int p=cur.power;

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
                    pq.offer(new State(v, dist[v][newP], newP));
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