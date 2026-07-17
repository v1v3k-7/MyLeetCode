class Solution {
    static boolean isSubsetSum(int arr[], int sum) 
    {
        int n=arr.length;
        Boolean[][] dp=new Boolean[n][sum+1];
        
        return solve(n-1, arr, sum, dp);
    }
    private static boolean solve(int idx, int[] arr, int target, Boolean[][] dp)
    {
        if(target==0) return true;
        if(idx==0)
        {
            if(target==arr[0]) return true;
            else return false;
        }
        
        if(dp[idx][target]!=null) return dp[idx][target];
        
        if(target>=arr[idx])
        {
            boolean pick=solve(idx-1, arr, target-arr[idx], dp);
            if(pick) return true;
        }
        
        boolean noPick=solve(idx-1, arr, target, dp);
        return dp[idx][target]=noPick;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna