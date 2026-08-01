class Solution {
    public boolean predictTheWinner(int[] nums) 
    {
        int n=nums.length;
        int totalSum=Arrays.stream(nums).sum();
        Integer[][] dp=new Integer[n][n];
        int player1Score=solve(0, n-1, nums, dp);
        int player2Score=totalSum-player1Score;
        return player1Score>=player2Score;
    }
    // return difference b/w player1-player2
    private int solve(int left, int right, int[] nums, Integer[][] dp)
    {
        if(left>right) return 0;
        if(left==right) return nums[left];

        if(dp[left][right]!=null) return dp[left][right];

        int pickLeft=nums[left] + Math.min(solve(left+2, right, nums, dp), solve(left+1, right-1, nums, dp));
        int pickRight=nums[right] + Math.min(solve(left+1, right-1, nums, dp), solve(left, right-2, nums, dp));
        
        return dp[left][right]=Math.max(pickLeft, pickRight);
    }
}