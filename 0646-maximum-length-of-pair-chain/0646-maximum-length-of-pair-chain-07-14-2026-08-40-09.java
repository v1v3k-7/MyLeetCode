class Solution {
    public int findLongestChain(int[][] pairs) 
    {
        Arrays.sort(pairs, (a,b)->Integer.compare(a[0], b[0]));
        int n=pairs.length;
        int[] dp=new int[n];
        dp[0]=1; //sabi pair ka length atleast 1 hoga hi, khud ka length
        int maxLen=1;
        for(int i=1; i<n; i++)
        {
            dp[i]=1;
            for(int j=0; j<i; j++)
            {
                if(pairs[j][1]<pairs[i][0])
                {
                    dp[i]=Math.max(dp[j]+1, dp[i]);
                }
                if(dp[i]>maxLen) maxLen=dp[i];
            }
        }
        return maxLen;
    }

    // private int solve(int idx, int[][] pairs, int prev, int[][] dp)
    // {
    //     if(idx==pairs.length) return 0;

    //     if(prev!=-1 && dp[idx][prev]!=-1) return dp[idx][prev];

    //     int pick=0;
    //     if(prev==-1 || pairs[idx][0]>pairs[prev][1])
    //     {
    //         pick=1+solve(idx+1, pairs, idx, dp);
    //     }
    //     int noPick=solve(idx+1, pairs, prev, dp);
        
    //     if(prev!=-1) dp[idx][prev]=Math.max(pick, noPick);
    //     return Math.max(pick, noPick);
    // }
}