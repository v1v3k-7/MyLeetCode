class Solution 
{
    public long maxAlternatingSum(int[] nums) 
    {
        long[][] dp=new long[2][nums.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return solve(nums, 0, 0, dp);
    }
    public long solve(int[] nums, int idx, int isEven, long[][] dp)
    {
        if(idx==nums.length) return 0;
        if(dp[isEven][idx]!=-1) return dp[isEven][idx];

        long val=(isEven==0)?nums[idx]:-nums[idx];
        long pick=val+solve(nums, idx+1, 1-isEven, dp);

        long noPick=solve(nums, idx+1, isEven, dp);

        return dp[isEven][idx]=Math.max(pick, noPick);
    }
}