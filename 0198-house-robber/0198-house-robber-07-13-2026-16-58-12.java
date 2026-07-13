class Solution {
    //DP Bottom-Up Approach
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return nums[0];

        int[] dp=new int[n]; //dp[i] -> ith house tak me maximun chori
        dp[0]=nums[0]; //first house me max chori
        dp[1]=Math.max(nums[0], nums[1]); //[0-1] first sec mese se max chori;
        for(int i=2; i<n; i++)
        {
            dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1]; //return last house tak me max chori
    }


    // private int solve(int[] nums, int idx, int[] dp)
    // {
    //     if(idx>=nums.length) return 0;
    //     if(dp[idx]!=-1) return dp[idx];

    //     //pick the house case (if picking ith house, mean after than he can only pick i+2th house or uske bad ka)
    //     int pick=nums[idx] + solve(nums, idx+2, dp);

    //     //didn't picked ith house, not he can pick only i+1 house or uske bad k house mese
    //     int noPick= solve(nums, idx+1, dp);

    //     return dp[idx]=Math.max(pick, noPick);
    // }
}