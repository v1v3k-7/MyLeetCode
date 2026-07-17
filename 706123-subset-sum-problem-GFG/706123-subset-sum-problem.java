class Solution {
    static boolean isSubsetSum(int arr[], int sum) 
    {
        int n=arr.length;
        return solve(n-1, arr, sum);
    }
    private static boolean solve(int idx, int[] arr, int target)
    {
        if(target==0) return true;
        if(idx==0)
        {
            if(target==arr[0]) return true;
            else return false;
        }
        
        if(target>=arr[idx])
        {
            boolean pick=solve(idx-1, arr, target-arr[idx]);
            if(pick) return true;
        }
        
        boolean noPick=solve(idx-1, arr, target);
        return noPick;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna