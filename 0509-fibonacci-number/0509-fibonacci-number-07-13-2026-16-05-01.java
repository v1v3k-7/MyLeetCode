class Solution 
{
    //DP Bottom-Up Approach (Space Optimization)
    public int fib(int n) 
    {
        if(n<=1) return n;
        int prev1=1, prev2=0;
        int ans=0;
        for(int i=2; i<=n; i++)
        {
            ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;
        }
        return ans;
    }
    // public int solve(int n)
    // {
    //     if(n<=1) return n;
    //     if(dp[n]!=-1) return dp[n];

    //     int x1=solve(n-1);
    //     int x2=solve(n-2);
    //     return dp[n]=x1+x2;
    // }
}