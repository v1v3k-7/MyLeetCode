class Solution {
    public int knapsack(int W, int val[], int wt[]) 
    {
        int n=val.length;
        int[][] dp=new int[n+1][W+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        return solve(n, W, val, wt, dp);
    }
    private int solve(int n, int W, int[] val, int[] wt, int[][] dp)
    {
        if(n==0||W==0) return 0;
        
        if(dp[n][W]!=-1) return dp[n][W];
        
        int take=0;
        if(wt[n-1]<=W)
            take=val[n-1] + solve(n-1, W-wt[n-1], val, wt, dp);
        
        int notTake=solve(n-1, W, val, wt, dp);
        
        return dp[n][W]=Math.max(take, notTake);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna