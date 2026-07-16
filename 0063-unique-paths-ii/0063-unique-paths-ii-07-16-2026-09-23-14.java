class Solution {
    int row, col;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        row=obstacleGrid.length;
        col=obstacleGrid[0].length;
        int[][] dp=new int[row][col]; //dp[i][j] -> grid[i][j] tak pahuchne ka max kitne unique path hai
        for(int j=0; j<col; j++)
        {
            if(obstacleGrid[0][j]==1) break;
            else dp[0][j]=1;
        }
        for(int i=0; i<row; i++)
        {
            if(obstacleGrid[i][0]==1) break;
            else dp[i][0]=1;
        }
        for(int i=1; i<row; i++)
        {
            for(int j=1; j<col; j++)
            {
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[row-1][col-1];
    }
}