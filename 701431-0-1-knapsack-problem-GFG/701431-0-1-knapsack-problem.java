class Solution {
    public int knapsack(int W, int val[], int wt[]) 
    {
        int n=val.length;
        int[][] dp=new int[n][W+1]; //dp[i][j] -> max kitne val le skte hai agar 
                                    // val[0:i] tak hi hai and max capacity(W) j ho to
        for(int j=0; j<=W; j++)
        {
            if(j<wt[0]) dp[0][j]=0;
            else dp[0][j]=val[0]; //chahe kitna b max capacity jyada ho weight[0] ka value ek hi bar le skte
        }
        //and pure first column me b zero rhega kyuki W(j=0) hai yha to maxCap hi 0 hai to koi val aa hi nhi skta
        
        for(int i=1; i<n; i++)
        {
            for(int j=1; j<=W; j++)
            {
                int take=0;
                if(wt[i]<=j) //maxCap(j) se km hoga weight tabi le skte
                {
                    int remain=j-wt[i];
                    take=val[i] + dp[i-1][remain];
                }
                int notTake=dp[i-1][j];
                dp[i][j]=Math.max(take, notTake);
            }
        }
        
        return dp[n-1][W];
        
    }
    // private int solve(int n, int W, int[] val, int[] wt, int[][] dp)
    // {
    //     if(n==0||W==0) return 0;
        
    //     if(dp[n][W]!=-1) return dp[n][W];
        
    //     int take=0;
    //     if(wt[n-1]<=W)
    //         take=val[n-1] + solve(n-1, W-wt[n-1], val, wt, dp);
        
    //     int notTake=solve(n-1, W, val, wt, dp);
        
    //     return dp[n][W]=Math.max(take, notTake);
    // }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna