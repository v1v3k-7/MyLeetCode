class Solution 
{
    // DP Bottom-Up Arroach
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        int dp[]=new int[n]; //dp[i] -> ith house tak me max kitna chori

        //case 1: including first house and excluding last houes
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<n-1; i++)
        {
            dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        int case1=dp[n-2];

        //case 2: excluding first house and including last house;
        dp[1]=nums[1];
        dp[2]=Math.max(nums[1], nums[2]);
        for(int i=3; i<n; i++)
        {
            dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        int case2=dp[n-1];

        return Math.max(case1, case2);
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