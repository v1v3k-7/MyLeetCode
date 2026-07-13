class Solution 
{
    int dp[];
    public int fib(int n) 
    {
        dp=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
    public int solve(int n)
    {
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];

        int x1=solve(n-1);
        int x2=solve(n-2);
        return dp[n]=x1+x2;
    }
}