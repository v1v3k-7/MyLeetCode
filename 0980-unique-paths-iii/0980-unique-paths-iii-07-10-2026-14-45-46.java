class Solution {
    int row, col;
    public int uniquePathsIII(int[][] grid) 
    {
        row=grid.length;
        col=grid[0].length;
        int res=0;
        int obstacles=0;
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j]==-1) 
                {
                    obstacles++;
                }
            }
        }
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j]==1) 
                {
                    res+=dfs(grid, i, j, row*col-obstacles);
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int r, int c, int remain)
    {
        if(r<0||r>=row||c<0||c>=col || grid[r][c]==-1) return 0;
        if(grid[r][c]==2)
        {
            if(remain==1) return 1;
            return 0;
        }

        int count=0;
        int temp=grid[r][c];
        grid[r][c]=-1; //visited
        
        count+=dfs(grid, r, c+1, remain-1); //left;
        count+=dfs(grid, r, c-1, remain-1); //right;
        count+=dfs(grid, r-1, c, remain-1); //up;
        count+=dfs(grid, r+1, c, remain-1); //down;

        grid[r][c]=temp; //remove visited mark;

        return count;
    }
}