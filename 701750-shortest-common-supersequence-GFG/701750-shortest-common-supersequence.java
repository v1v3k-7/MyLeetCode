class Solution 
{
    public static int minSuperSeq(String s1, String s2) 
    {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1]; //dp[i][j] -> s1 mese ith and s2 mese jth tak me SCS kal length
        for(int j=0; j<=m; j++) dp[0][j]=j;
        for(int i=0; i<=n; i++) dp[i][0]=i;
        
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=1+Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    
    // private static int solve(int i, int j, String s1, String s2, int[][] dp)
    // {
    //     if(i==n) return m-j;
    //     if(j==m) return n-i;
        
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(s1.charAt(i)==s2.charAt(j))
    //     {
    //         return dp[i][j]=1+solve(i+1, j+1, s1, s2, dp);
    //     }
    //     else
    //     {
    //         return dp[i][j]=Math.min(
    //                 1+solve(i, j+1, s1, s2, dp), 
    //                 1+solve(i+1, j, s1, s2, dp)
    //             );
    //     }
    // }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna