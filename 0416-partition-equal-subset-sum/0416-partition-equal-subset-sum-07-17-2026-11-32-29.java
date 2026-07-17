class Solution {
    public boolean canPartition(int[] nums) 
    {
        int total=0;
        int n=nums.length;
        for(int no: nums) total+=no;
        if((total&1)==1) return false;

        int target=total/2;
        Boolean[][] dp=new Boolean[n][target+1];
        return solve(n-1, target, nums, dp);
    }
    private boolean solve(int idx, int target, int[] nums, Boolean[][] dp)
    {
        if(target==0) return true;
        if(idx==0)
        {
            if(nums[idx]==target) return true;
            else return false;
        }

        if(dp[idx][target]!=null) return dp[idx][target];

        if(nums[idx]<=target)
        {
            boolean pick=solve(idx-1, target-nums[idx], nums, dp);
            if(pick) return true;
        }
        boolean noPick=solve(idx-1, target, nums, dp);
        return dp[idx][target]=noPick;
    }
}