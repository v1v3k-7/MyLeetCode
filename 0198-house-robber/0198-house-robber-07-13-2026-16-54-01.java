class Solution {
    //DP Top-Down Approach
    public int rob(int[] nums) 
    {
        int[] dp=new int[nums.length]; //ith house and uske bad k ghar mese max stolen money [i, n-1]
        Arrays.fill(dp, -1);
        solve(nums, 0, dp);
        return dp[0]; //return 0th house to n-1 house ka max
    }
    private int solve(int[] nums, int idx, int[] dp)
    {
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];

        //pick the house case (if picking ith house, mean after than he can only pick i+2th house or uske bad ka)
        int pick=nums[idx] + solve(nums, idx+2, dp);

        //didn't picked ith house, not he can pick only i+1 house or uske bad k house mese
        int noPick= solve(nums, idx+1, dp);

        return dp[idx]=Math.max(pick, noPick);
    }
}