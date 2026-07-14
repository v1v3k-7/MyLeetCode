class Solution {
    //DP Top-Down Approach(Memo)
    int n,m;
    public int longestCommonSubsequence(String text1, String text2) 
    {
        n=text1.length();
        m=text2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, text1, text2, dp);
    }
    private int solve(int i, int j, String text1, String text2, int[][] dp)
    {
        if(i>=n || j>=m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j))
        {
            return dp[i][j]=1+solve(i+1, j+1, text1, text2, dp);
        }
        else
        {
            int inc1=solve(i+1, j, text1, text2, dp);
            int inc2=solve(i, j+1, text1, text2, dp);
            return dp[i][j]=Math.max(inc1, inc2);
        }
    }
}