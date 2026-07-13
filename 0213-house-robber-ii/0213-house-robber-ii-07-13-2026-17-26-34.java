class Solution 
{
    // DP Bottom-Up Arroach (Space Optimization)
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        //case1: including first house and excluding last house;
        int prevHouse2=nums[0];
        int prevHouse1=Math.max(nums[0], nums[1]);
        int ans1=prevHouse1;
        for(int i=2; i<n-1; i++)
        {
            ans1=Math.max(prevHouse1, nums[i]+prevHouse2);
            prevHouse2=prevHouse1;
            prevHouse1=ans1;
        }
        
        //case 2: excluding first house and including last house;
        prevHouse2=nums[1];
        prevHouse1=Math.max(nums[1], nums[2]);
        int ans2=prevHouse1;
        for(int i=3; i<n; i++)
        {
            ans2=Math.max(prevHouse1, nums[i]+prevHouse2);
            prevHouse2=prevHouse1;
            prevHouse1=ans2;
        }
        
        return Math.max(ans1, ans2);
    }

    // public int solve(int idx, int lastHouse, int[] nums, int[] dp)
    // {
    //     if(idx>=lastHouse) return 0;
    //     if(dp[idx]!=-1) return dp[idx];

    //     int pick=nums[idx]+solve(idx+2, lastHouse, nums, dp);
    //     int noPick=solve(idx+1, lastHouse, nums, dp);
        
    //     return dp[idx]=Math.max(pick, noPick);
    // }
}