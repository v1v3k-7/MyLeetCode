class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        return solve(nums, 0, -1);
    }
    private int solve(int[] nums, int idx, int prev)
    {
        if(idx==nums.length) return 0;

        int pick=0;
        if(prev==-1 || nums[idx]>nums[prev])
        {
            pick=1+solve(nums, idx+1, idx);
        }
        int noPick=solve(nums, idx+1, prev);

        return Math.max(pick, noPick);
    }
}
