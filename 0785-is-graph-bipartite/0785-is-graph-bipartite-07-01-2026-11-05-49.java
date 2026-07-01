class Solution {
    //BFS
    //represt set A with greeen color - 0, and set B as red color - 1, and not seen with -1(no color);
    public boolean isBipartite(int[][] graph) 
    {
        int nodes=graph.length;
        int[] color=new int[nodes];
        Arrays.fill(color, -1); //initially no color

        for(int i=0; i<nodes; i++)
        {
            if(color[i]==-1)
            {
                if(!bfs(i, graph, color))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int src, int[][] graph, int[] color)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(src);
        color[src]=0;
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int neighbour: graph[node])
            {
                if(color[neighbour]!=-1)
                {
                    if(color[node]==color[neighbour]) return false;
                    else continue;
                }
                color[neighbour]=1-color[node]; //toggle color/set;
                queue.offer(neighbour);
            }
        }
        return true;
    }
}