class Solution 
{
    //DP Bottom-Up Approach 
    public int climbStairs(int n) 
    {
        if(n<=2) return n;
        // int[] dp=new int[n+1]; //dp[i] = ith stair pe chadhne ka total ways;
        int prev1=2;
        int prev2=1;
        int ans=0;
        for(int i=3; i<=n; i++)
        {
            ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;
        }
        // return dp[n];
        return ans;
    }

    // public int solve(int n, int[] dp)
    // {
    //     if(n<=2) return n;
    //     if(dp[n]!=0) return dp[n];

    //     return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    // }
}