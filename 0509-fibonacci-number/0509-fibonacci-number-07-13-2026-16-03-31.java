class Solution 
{
    //DP Bottom-Up Approach
    public int fib(int n) 
    {
        if(n<=1) return n;
        int dp[]=new int[n+1]; //dp[i]--> ith term ka fibonacci kya hoga
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<=n; i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
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