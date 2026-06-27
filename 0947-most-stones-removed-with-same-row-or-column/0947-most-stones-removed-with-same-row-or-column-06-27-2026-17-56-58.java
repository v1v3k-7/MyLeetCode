class Solution {
    public int removeStones(int[][] stones) 
    {
        int nodes=stones.length;
        //create adjList
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<nodes; i++) adjList.add(new ArrayList<>());
        for(int i=0; i<nodes; i++)
        {
            for(int j=i+1; j<nodes; j++)
            {
                if(stones[i][0]==stones[j][0]) //same row
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
                else if(stones[i][1]==stones[j][1]) //same column
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        // System.out.println(adjList);
        boolean[] visited=new boolean[nodes];
        int components=0;
        for(int i=0; i<nodes; i++)
        {
            if(!visited[i]) 
            {
                components++;
                dfs(i, visited, adjList);
            }
        }
        return nodes-components;
    }
    public void dfs(int src, boolean[] visited, List<List<Integer>> adjList)
    {
        for(int neighbour: adjList.get(src))
        {
            if(!visited[neighbour])
            {
                visited[neighbour]=true;
                dfs(neighbour, visited, adjList);
            }
        }
    }
}