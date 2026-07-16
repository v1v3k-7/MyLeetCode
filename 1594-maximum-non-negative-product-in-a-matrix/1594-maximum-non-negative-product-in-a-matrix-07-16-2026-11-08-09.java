class Pair
{
    long max, min;
    Pair(long min, long max)
    {
        this.max=max;
        this.min=min;
    }
}
class Solution 
{
    final static long mod=1_000_000_007;
    public int maxProductPath(int[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;
        Pair[][] dp=new Pair[row][col];
        Pair res=solve(row-1, col-1, grid, dp);
        long max=res.max;
        if(max<0) return -1;
        else return (int)(max%mod);
    }
    private Pair solve(int r, int c, int[][] grid, Pair[][] dp) //return [max, min]
    {
        if(r==0 && c==0) return new Pair(grid[0][0], grid[0][0]);

        if(dp[r][c]!=null) return dp[r][c];

        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;

        if(r>0)
        {
            Pair fromTop=solve(r-1, c, grid, dp);
            min=Math.min(min, Math.min(grid[r][c]*fromTop.min, grid[r][c]*fromTop.max));
            max=Math.max(max, Math.max(grid[r][c]*fromTop.min, grid[r][c]*fromTop.max));
        }
        if(c>0)
        {
            Pair fromLeft=solve(r, c-1, grid, dp);
            min=Math.min(min, Math.min(grid[r][c]*fromLeft.min, grid[r][c]*fromLeft.max));
            max=Math.max(max, Math.max(grid[r][c]*fromLeft.min, grid[r][c]*fromLeft.max));
        }
        return dp[r][c]=new Pair(min, max);
    }
}