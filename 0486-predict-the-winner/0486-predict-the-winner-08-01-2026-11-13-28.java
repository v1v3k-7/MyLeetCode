class Solution {
    public boolean predictTheWinner(int[] nums) 
    {
        return solve(0, nums.length-1, nums)>=0;
    }
    private int solve(int left, int right, int[] nums) //player - 0 (1st player), 1 (2nd player)
    {
        if(left==right)
        {
            return nums[left];
        }

        int pickLeft=nums[left] - solve(left+1, right, nums);
        int pickRight=nums[right] - solve(left, right-1, nums);
        
        return Math.max(pickLeft, pickRight);
    }
}