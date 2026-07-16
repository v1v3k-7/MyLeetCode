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
        Pair[][] dp=new Pair[row][col]; //dp[i][j] -> grid[i][j] tak pahuchne me paths ka product min or max dono
        dp[0][0]=new Pair(grid[0][0], grid[0][0]);
        for(int j=1; j<col; j++)
        {
            long mul=grid[0][j] * dp[0][j-1].min; // u take max too bcz both are same in first row & col
            dp[0][j]=new Pair(mul, mul);
        }
        for(int i=1; i<row; i++)
        {
            long mul=grid[i][0] * dp[i-1][0].min; // u take max too bcz both are same in first row & col
            dp[i][0]=new Pair(mul, mul);
        }
        for(int i=1; i<row; i++)
        {
            for(int j=1; j<col; j++)
            {
                long num=grid[i][j];
                long min=Long.MAX_VALUE;
                long max=Long.MIN_VALUE;
                Pair fromLeft=dp[i][j-1];
                min=Math.min(num*fromLeft.min, num*fromLeft.max);
                max=Math.max(num*fromLeft.min, num*fromLeft.max);
                Pair fromTop=dp[i-1][j];
                min=Math.min(min, Math.min(num*fromTop.min, num*fromTop.max));
                max=Math.max(max, Math.max(num*fromTop.min, num*fromTop.max));

                dp[i][j]=new Pair(min, max);
            }
        }
        long res=dp[row-1][col-1].max;
        if(res<0) return -1;
        else return (int)(res%mod);
    }
}