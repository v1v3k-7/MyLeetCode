class Solution 
{
    int row, col;
    public int getMaximumGold(int[][] grid) 
    {
        row=grid.length;
        col=grid[0].length;
        int res=0;
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j]!=0)
                {
                    res=Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int r, int c)
    {
        if(r>=row || r<0 || c>=col || c<0 || grid[r][c]==0) return 0;

        int gold=grid[r][c];

        grid[r][c]=0;
        
        int left=dfs(grid, r, c-1);
        int right=dfs(grid, r, c+1);
        int down=dfs(grid, r+1, c);
        int up=dfs(grid, r-1, c);

        grid[r][c]=gold;

        return gold + Math.max(
            Math.max(left, right),
            Math.max(up, down)
        );
    }
}