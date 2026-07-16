class Solution {
    int row, col;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        row=obstacleGrid.length;
        col=obstacleGrid[0].length;
        int[][] dp=new int[row][col];
        for(int i=0; i<row; i++) Arrays.fill(dp[i], -1);
        return solve(row-1, col-1, obstacleGrid, dp);
    }
    private int solve(int r, int c, int[][] grid, int[][] dp)
    {
        if(r>=row || r<0 || c>=col || c<0 || grid[r][c]==1) return 0;
        if(r==0 && c==0) return 1;
        if(dp[r][c]!=-1) return dp[r][c];
        return dp[r][c]=solve(r-1,c,grid, dp) + solve(r,c-1,grid, dp);
    }
}