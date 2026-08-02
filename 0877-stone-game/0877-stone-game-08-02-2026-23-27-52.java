class Solution {
    public boolean stoneGame(int[] piles) 
    {
        int n=piles.length;
        Integer[][] dp=new Integer[n][n];
        return solve(0, n-1, piles, dp)>0;
    }
    //return difference of both player
    private int solve(int left, int right, int[] piles, Integer[][] dp)
    {
        if(left==right) return piles[left];
        if(dp[left][right]!=null) return dp[left][right];

        int fromLeft=piles[left]-solve(left+1, right, piles, dp);
        int fromRight=piles[right]-solve(left, right-1, piles, dp);

        return dp[left][right]=Math.max(fromLeft, fromRight);
    }
}