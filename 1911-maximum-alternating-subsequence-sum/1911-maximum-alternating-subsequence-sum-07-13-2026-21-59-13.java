class Solution 
{
    //DP Bottom-Up Approach
    public long maxAlternatingSum(int[] nums) 
    {
        int n=nums.length;
        long[][] dp=new long[2][n]; //dp[0] -> even, dp[1] -> odd
        dp[0][0]=nums[0]; //dp[even][0]=
        dp[1][0]=0; //dp[odd][o] = 0 hi hoga n max kyuki minus krenge to -nums[0] ho jayega, so 0 better pick hi mat kro. max noPick hi hoga

        for(int i=1; i<n; i++)
        {
            dp[0][i]=Math.max(dp[1][i-1]+nums[i], dp[0][i-1]); //even
            dp[1][i]=Math.max(dp[0][i-1]-nums[i], dp[1][i-1]); //odd
        }

        return Math.max(dp[1][n-1], dp[0][n-1]);
    }


    // public long solve(int[] nums, int idx, int isEven, long[][] dp)
    // {
    //     if(idx==nums.length) return 0;
    //     if(dp[isEven][idx]!=-1) return dp[isEven][idx];

    //     long val=(isEven==0)?nums[idx]:-nums[idx];
    //     long pick=val+solve(nums, idx+1, 1-isEven, dp);

    //     long noPick=solve(nums, idx+1, isEven, dp);

    //     return dp[isEven][idx]=Math.max(pick, noPick);
    // }
}