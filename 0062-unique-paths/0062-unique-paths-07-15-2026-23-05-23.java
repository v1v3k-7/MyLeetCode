class Solution {
    public int uniquePaths(int m, int n) 
    {
        int[][] dp=new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return solve(m-1, n-1, m, n, dp);
    }
    private int solve(int r, int c, int m, int n, int[][] dp)
    {
        if(r>=m || r<0 || c>=n || c<0) return 0;
        else if(r==0||c==0) return 1;

        if(dp[r][c]!=-1) return dp[r][c];

        int fromTop=solve(r-1, c, m, n, dp);
        int fromLeft=solve(r, c-1, m, n, dp);

        return dp[r][c]=fromTop+fromLeft;
    }
}