class Solution {
    public int findLongestChain(int[][] pairs) 
    {
        Arrays.sort(pairs, (a,b)->Integer.compare(a[0], b[0]));
        int n=pairs.length;
        int[][] dp=new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        return solve(0, pairs, -1, dp);
    }
    private int solve(int idx, int[][] pairs, int prev, int[][] dp)
    {
        if(idx==pairs.length) return 0;

        if(prev!=-1 && dp[idx][prev]!=-1) return dp[idx][prev];

        int pick=0;
        if(prev==-1 || pairs[idx][0]>pairs[prev][1])
        {
            pick=1+solve(idx+1, pairs, idx, dp);
        }
        int noPick=solve(idx+1, pairs, prev, dp);
        
        if(prev!=-1) dp[idx][prev]=Math.max(pick, noPick);
        return Math.max(pick, noPick);
    }
}