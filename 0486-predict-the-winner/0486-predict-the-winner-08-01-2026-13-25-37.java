class Solution {
    public boolean predictTheWinner(int[] nums) 
    {
        int n=nums.length;
        Integer[][] dp=new Integer[n][n];
        
        return solve(0, n-1, nums, dp)>=0;
    }
    // return difference b/w player1-player2
    private int solve(int left, int right, int[] nums, Integer[][] dp)
    {
        if(left==right)
        {
            return nums[left];
        }
        if(dp[left][right]!=null) return dp[left][right];

        int pickLeft=nums[left] - solve(left+1, right, nums, dp);
        int pickRight=nums[right] - solve(left, right-1, nums, dp);
        
        return dp[left][right]=Math.max(pickLeft, pickRight);
    }
}