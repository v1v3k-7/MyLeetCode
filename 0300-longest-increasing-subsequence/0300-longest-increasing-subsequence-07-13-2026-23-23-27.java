class Solution {
    // DP Bottom-Up Approach
    public int lengthOfLIS(int[] nums) 
    {
        int n=nums.length;
        int[] dp=new int[n]; // dp[i] -> Length of LIS ending at index i
        // Arrays.fill(dp, 1); //sabka length abhi 1 hi hai
        dp[0]=1;
        int maxLen=1;
        for(int i=1; i<n; i++)
        {
            dp[i]=1;
            for(int j=0; j<i; j++)
            {
                if(nums[j]<nums[i])
                {
                    dp[i]=Math.max(dp[j]+1, dp[i]);
                }
                if(dp[i]>maxLen) maxLen=dp[i];
            }
        }
        return maxLen;
    }

    // private int solve(int[] nums, int idx, int prev)
    // {
    //     if(idx==nums.length) return 0;
    //     if(prev!=-1 && dp[prev][idx]!=-1) return dp[prev][idx];

    //     int pick=0;
    //     if(prev==-1 || nums[idx]>nums[prev])
    //     {
    //         pick=1+solve(nums, idx+1, idx);
    //     }
    //     int noPick=solve(nums, idx+1, prev);

    //     if(prev!=-1) dp[prev][idx]=Math.max(pick, noPick);
    //     return Math.max(pick, noPick);
    // }
}