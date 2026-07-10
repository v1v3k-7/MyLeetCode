class Solution 
{
    int n;
    int[][] dp;
    public int combinationSum4(int[] nums, int target) 
    {
        n=nums.length;
        dp=new int[n][target+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        return backtrack(0, nums, target);
    }

    public int backtrack(int idx, int[] nums, int target)
    {
        if(target==0) return 1;
        if(idx>=nums.length || target<0) return 0;

        if(dp[idx][target]!=-1) return dp[idx][target];

        int take=backtrack(0, nums, target-nums[idx]);
        int noTake=backtrack(idx+1, nums, target); //increase index

        return dp[idx][target]=take+noTake;
    }
}