class Solution {
    int row, col;
    public int calculateMinimumHP(int[][] dungeon) 
    {
        row=dungeon.length;
        col=dungeon[0].length;
        int[][] dp=new int[row][col]; //dp[i][j] -> dungeon[i][j] se dungeon[row-1][col-1] tak pahuchne k lie minimum health kitna required hai.
        dp[row-1][col-1]=(dungeon[row-1][col-1]<0)?Math.abs(dungeon[row-1][col-1])+1:1;
        for(int i=row-2; i>=0; i--)
        {
            int val=dungeon[i][col-1];
            dp[i][col-1]=(dp[i+1][col-1]<=val)?1:dp[i+1][col-1]-val;
        }
        for(int j=col-2; j>=0; j--)
        {
            int val=dungeon[row-1][j];
            dp[row-1][j]=(dp[row-1][j+1]<=val)?1:dp[row-1][j+1]-val;
        }
        for(int r=row-2; r>=0; r--)
        {
            for(int c=col-2; c>=0; c--)
            {
                int val=dungeon[r][c];

                int right=dp[r][c+1];
                int down=dp[r+1][c];
                int need=Math.min(right, down);
                dp[r][c]=(val>=need)?1:need-val;
            }
        }
        return dp[0][0];
    }
    // private int solve(int r, int c, int[][] dungeon, int[][] dp)
    // {
    //     if(r>=row || c>=col) return Integer.MAX_VALUE;
    //     int val=dungeon[r][c];
    //     if(r==row-1 && c==col-1)
    //     {
    //         if(val<=0) return Math.abs(val)+1;
    //         else return 1;
    //     }

    //     if(dp[r][c]!=0) return dp[r][c];

    //     int right=solve(r ,c+1, dungeon, dp);
    //     int down=solve(r+1, c, dungeon, dp);

    //     int need=Math.min(right, down);
    //     // if(val>=need) return 1;
    //     // else return need-val;
    //     return dp[r][c]=(val>=need)?1:need-val;
    // }
}