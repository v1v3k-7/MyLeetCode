class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) 
    {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<n; i++) map.put(i, new ArrayList<>());
        for(int[] i: edges)
        {
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        return dfs(0, -1, hasApple, map);
    }
    public int dfs(int src, int parent, List<Boolean> hasApple, HashMap<Integer, List<Integer>> map)
    {
        int totalTime=0;
        for(int neighbour:map.get(src))
        {
            if(neighbour==parent) continue;
            int timeByNeighbour=dfs(neighbour, src, hasApple, map);
            if(timeByNeighbour>0 || hasApple.get(neighbour))
            {
                totalTime+=timeByNeighbour+2;
            }
        }
        return totalTime;
    }
}