class Solution {
    //dijkstra's algorithm
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        int[] dist=new int[n+1]; //taking one extra bcz node start from 1 not 0. during check we will ignore 0 index everywhere
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;

        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int[] edge: times)
        {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        //store [node, distance from source] in pq
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[1], b[1]);
            }
        });
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty())
        {
            int[] pair=pq.poll();
            int u=pair[0];
            int d=pair[1];
            if(d>dist[u]) continue;
            for(int[] neighbour: adj.get(u))
            {
                int v=neighbour[0];
                int w=neighbour[1];
                if(dist[u]+w<dist[v])
                {
                    dist[v]=dist[u]+w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1; i<=n; i++)
        {
            if(dist[i]==Integer.MAX_VALUE) return -1;
            if(dist[i]>max) max=dist[i];
        }
        return max;
    }
}