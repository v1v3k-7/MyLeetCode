class Solution {
    //DP Bottom-Up Approach (Space Optimization)
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return nums[0];
        int prevHouse2=nums[0];
        int prevHouse1=Math.max(nums[1], nums[0]);
        if(n==2) return prevHouse1;
        int ans=0;
        for(int i=2; i<n; i++)
        {
            ans=Math.max(prevHouse1, nums[i]+prevHouse2);
            prevHouse2=prevHouse1;
            prevHouse1=ans;
        }
        return ans;
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