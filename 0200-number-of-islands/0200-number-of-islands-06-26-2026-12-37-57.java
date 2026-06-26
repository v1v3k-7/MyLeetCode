class Solution 
{
    //DFS
    int rows;
    int cols;
    public int numIslands(char[][] grid) 
    {
        //we will mark visited by 2;
        rows=grid.length;
        cols=grid[0].length;
        int islands=0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j]!='1') continue; //visited or water cell, no need to bds again here so continue;
                islands++;
                //commented below line because in dfs we will mark visited later in function
                // grid[i][j]='2'; //mark as visited
                DFS(grid, i, j);
            }
        }
        return islands;
    }

    public void DFS(char[][] grid, int r, int c)
    {
        if(r>=rows||r<0||c>=cols||c<0||grid[r][c]!='1') return;
        
        grid[r][c]='2';
        int[][] directions={{r-1, c}, {r+1, c}, {r, c-1}, {r, c+1}};
        for(int[] dir: directions)
        {
            DFS(grid, dir[0], dir[1]);
        } 
    }
}