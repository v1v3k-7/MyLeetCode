class Solution 
{
    int n;
    int[] dp;
    public int combinationSum4(int[] nums, int target) 
    {
        n=nums.length;
        dp=new int[target+1];
        Arrays.fill(dp, -1);

        return backtrack(0, nums, target);
    }

    public int backtrack(int idx, int[] nums, int target)
    {
        if(target==0) return 1;
        if(idx>=nums.length) return 0;

        if(dp[target]!=-1) return dp[target];
        int take=0;
        if(nums[idx]<=target)
            take=backtrack(0, nums, target-nums[idx]);
        int noTake=backtrack(idx+1, nums, target); //increase index

        return dp[target]=take+noTake;
    }
}