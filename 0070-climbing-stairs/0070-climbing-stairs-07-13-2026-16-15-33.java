class Solution 
{
    //DP Top-Down Approach
    public int climbStairs(int n) 
    {
        if(n<=2) return n;
        int[] dp=new int[n+1]; //dp[i] = ith stair pe chadhne ka total ways;
        dp[1]=1;
        dp[2]=2;
        return solve(n, dp);
    }
    public int solve(int n, int[] dp)
    {
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];

        return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    }
}