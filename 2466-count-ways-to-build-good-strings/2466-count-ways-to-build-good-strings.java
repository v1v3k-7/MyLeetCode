class Solution {
    //Tabulation
    final int MOD=1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) 
    {
        int maxLen=high+Math.max(zero, one);
        int dp[]=new int[maxLen+1];

        for(int len=high; len>=0; len--)
        {
            long count=0;
            if(len>=low) count++;
            count+=dp[len+zero];
            count+=dp[len+one];
            dp[len]=(int)count % MOD;
        }
        // Arrays.fill(dp, -1);
        // return backtrack(low, high, zero, one, 0, dp);
        return dp[0];

    }
    // public int backtrack(int low, int high, int zero, int one, int len, int[] dp)
    // {
    //     if(len>high) dp[len]=0;
    //     if(dp[len]!=-1) return dp[len];
    //     long count=0;
    //     if(len>=low) count++;
    //     count+=backtrack(low, high, zero, one, len+zero, dp); //len + no of zero
    //     count+=backtrack(low, high, zero, one, len+one, dp); //len + no of one --> new Len in next call
    //     return dp[len]=(int)count%MOD;
    // }
}