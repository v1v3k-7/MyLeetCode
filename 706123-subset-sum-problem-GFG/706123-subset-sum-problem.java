class Solution {
    static boolean isSubsetSum(int arr[], int sum) 
    {
        int n=arr.length;
        boolean[][] dp=new boolean[n+1][sum+1]; //dp[i][j] -> subset 0 se i-1 (mean suru k ith) k all possible subset se j sum bna skte ya nhi
        for(int i=0; i<=n; i++) dp[i][0]=true; //sum=0 to bna hi skte hain, null subset le k
        
        //first row me sab befualt false hoga kyuki {} null state se kabhi koi sum nhi bna skte except zero
        
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=sum; j++)
            {
                boolean take=false;
                if(arr[i-1]<=j) //bcz doing 1 based indexing in i (subsets)
                {
                    int remain=j-arr[i-1];
                    take=dp[i-1][remain];
                }
                boolean skip=dp[i-1][j];
                
                dp[i][j]=skip||take;
            }
        }
        
        return dp[n][sum];
    }
    
    // private static boolean solve(int idx, int[] arr, int target, Boolean[][] dp)
    // {
    //     if(target==0) return true;
    //     if(idx==0)
    //     {
    //         if(target==arr[0]) return true;
    //         else return false;
    //     }
        
    //     if(dp[idx][target]!=null) return dp[idx][target];
        
    //     if(target>=arr[idx])
    //     {
    //         boolean pick=solve(idx-1, arr, target-arr[idx], dp);
    //         if(pick) return true;
    //     }
        
    //     boolean noPick=solve(idx-1, arr, target, dp);
    //     return dp[idx][target]=noPick;
    // }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna