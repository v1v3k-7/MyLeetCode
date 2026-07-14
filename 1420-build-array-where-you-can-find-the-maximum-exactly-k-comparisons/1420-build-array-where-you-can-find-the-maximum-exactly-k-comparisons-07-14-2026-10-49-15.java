class Solution {
    final static long MOD=1_000_000_007;
    long[][][] dp;
    public int numOfArrays(int n, int m, int k) 
    {
        dp=new long[n][m+1][m+1]; //idx, maxTillNow, currentCost;  cost max m tak hi aa skta hai agar ye sequence hua array ka 1, 2, ...m; to max cost jayega wo b m tak
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<=m; j++)
            {
                Arrays.fill(dp[i][j], -1L);
            }
        }
        return (int) solve(0, 0, -1, n, m, k);
    }

    private long solve(int idx, int cost, int maxTillNow, int n, int m, int k)
    {
        if(idx==n)
        {
            if(cost==k) return 1L;
            else return 0L;
        }

        if(maxTillNow!=-1 && dp[idx][maxTillNow][cost]!=-1L) return dp[idx][maxTillNow][cost];

        long res=0;
        for(int i=1; i<=m; i++)
        {
            if(i>maxTillNow)
            {
                res = (res + solve(idx+1, cost+1, i, n, m, k) % MOD) %MOD; //cost ek badh gya hai and maxTillNow ab i ho jayega
            }
            else
            {
                res = (res + solve(idx+1, cost, maxTillNow, n, m, k) % MOD) % MOD;
            }
        }
        if(maxTillNow!=-1) dp[idx][maxTillNow][cost]=res;
        return res;
    }
}