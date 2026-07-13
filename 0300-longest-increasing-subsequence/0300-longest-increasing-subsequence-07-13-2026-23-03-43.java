class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) 
    {
        int n=nums.length;
        dp=new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(nums, 0, -1);
    }
    private int solve(int[] nums, int idx, int prev)
    {
        if(idx==nums.length) return 0;
        if(prev!=-1 && dp[prev][idx]!=-1) return dp[prev][idx];

        int pick=0;
        if(prev==-1 || nums[idx]>nums[prev])
        {
            pick=1+solve(nums, idx+1, idx);
        }
        int noPick=solve(nums, idx+1, prev);

        if(prev!=-1) dp[prev][idx]=Math.max(pick, noPick);
        return Math.max(pick, noPick);
    }
}