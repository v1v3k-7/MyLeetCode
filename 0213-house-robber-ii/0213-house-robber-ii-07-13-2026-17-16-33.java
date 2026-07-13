class Solution 
{
    // DP Top-Down Arroach
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1) return nums[0];
        
        int[] dp=new int[n]; //dp[0]=0th to n-1 ka max stolen money;
        Arrays.fill(dp, -1);
        int case1=solve(0, n-1, nums, dp); //0th house to n-2th house;
        Arrays.fill(dp, -1);
        int case2=solve(1, n, nums, dp); //1th house to n-1th house

        return Math.max(case1, case2);
    }
    public int solve(int idx, int lastHouse, int[] nums, int[] dp)
    {
        if(idx>=lastHouse) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int pick=nums[idx]+solve(idx+2, lastHouse, nums, dp);
        int noPick=solve(idx+1, lastHouse, nums, dp);
        
        return dp[idx]=Math.max(pick, noPick);
    }
}