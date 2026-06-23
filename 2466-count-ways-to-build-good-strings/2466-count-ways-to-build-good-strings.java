class Solution {
    final int MOD=1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) 
    {
        Integer dp[]=new Integer[high+1];
        return backtrack(low, high, zero, one, 0, dp);
    }
    public int backtrack(int low, int high, int zero, int one, int len, Integer[] dp)
    {
        if(len>high) return 0;
        if(dp[len]!=null) return dp[len];
        long count=0;
        if(len>=low) count++;
        count+=backtrack(low, high, zero, one, len+zero, dp); //len + no of zero
        count+=backtrack(low, high, zero, one, len+one, dp); //len + no of one --> new Len in next call
        return dp[len]=(int)count%MOD;
    }
}