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
                if(!dfs(i, 0, graph, color))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int src, int curColor, int[][] graph, int[] color)
    {
        if(color[src]!=-1) return color[src]==curColor;
        color[src]=curColor;

        for(int neighbour: graph[src])
        {
            if(!dfs(neighbour, 1-curColor, graph, color)) return false;
        }
        return true;
    }
}