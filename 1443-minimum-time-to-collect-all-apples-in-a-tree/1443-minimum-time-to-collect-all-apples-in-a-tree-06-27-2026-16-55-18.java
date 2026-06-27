class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) 
    {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
        for(int[] i: edges)
        {
            adjList.get(i[0]).add(i[1]);
            adjList.get(i[1]).add(i[0]);
        }
        return dfs(0, -1, hasApple, adjList);
    }
    public int dfs(int src, int parent, List<Boolean> hasApple, List<List<Integer>> adjList)
    {
        int totalTime=0;
        for(int neighbour:adjList.get(src))
        {
            if(neighbour==parent) continue;
            int timeByNeighbour=dfs(neighbour, src, hasApple, adjList);
            if(timeByNeighbour>0 || hasApple.get(neighbour))
            {
                totalTime+=timeByNeighbour+2;
            }
        }
        return totalTime;
    }
}