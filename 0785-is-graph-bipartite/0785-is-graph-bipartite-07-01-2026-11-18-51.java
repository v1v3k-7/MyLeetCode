class Solution {
    //DFS
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
                if(!dfs(i, -1, graph, color))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int src, int parent, int[][] graph, int[] color)
    {
        if(color[src]!=-1)
        {
            if(color[src]==color[parent]) return false;
            else return true;
        }
    
        if(parent==-1) color[src]=0;
        else color[src]=1-color[parent];

        for(int neighbour: graph[src])
        {
            if(!dfs(neighbour, src, graph, color)) return false;
        }
        return true;
    }
}