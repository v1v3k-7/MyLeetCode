class Solution {
    int row, col;
    public int calculateMinimumHP(int[][] dungeon) 
    {
        row=dungeon.length;
        col=dungeon[0].length;
        int[][] dp=new int[row][col];
        return solve(0, 0, dungeon, dp);
    }
    private int solve(int r, int c, int[][] dungeon, int[][] dp)
    {
        if(r>=row || c>=col) return Integer.MAX_VALUE;
        int val=dungeon[r][c];
        if(r==row-1 && c==col-1)
        {
            if(val<=0) return Math.abs(val)+1;
            else return 1;
        }

        if(dp[r][c]!=0) return dp[r][c];

        int right=solve(r ,c+1, dungeon, dp);
        int down=solve(r+1, c, dungeon, dp);

        int need=Math.min(right, down);
        // if(val>=need) return 1;
        // else return need-val;
        return dp[r][c]=(val>=need)?1:need-val;
    }
}