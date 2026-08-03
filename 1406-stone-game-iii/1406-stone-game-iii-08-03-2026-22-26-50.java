class Solution {
    public String stoneGameIII(int[] stoneValue) 
    {
        Integer[] dp=new Integer[stoneValue.length];
        int res=solve(0, stoneValue, dp);
        if(res>0) return "Alice";
        else if(res<0) return "Bob";
        else return "Tie";
    }
    private int solve(int idx, int[] stoneValue, Integer[] dp)
    {
        int n=stoneValue.length;
        if(idx>=n) return 0;
        if(dp[idx]!=null) return dp[idx];
        int res=stoneValue[idx]-solve(idx+1, stoneValue, dp);
        if(idx+1<n) res=Math.max(res, stoneValue[idx]+stoneValue[idx+1]-solve(idx+2, stoneValue, dp));
        if(idx+2<n) res=Math.max(res, stoneValue[idx]+stoneValue[idx+1]+stoneValue[idx+2]-solve(idx+3, stoneValue, dp));
        return dp[idx]=res;
    }
}