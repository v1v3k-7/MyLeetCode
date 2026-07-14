class Solution 
{
    static int n, m;
    public static int minSuperSeq(String s1, String s2) 
    {
        n=s1.length();
        m=s2.length();
        int[][] dp=new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, s1, s2, dp);
    }
    private static int solve(int i, int j, String s1, String s2, int[][] dp)
    {
        if(i==n) return m-j;
        if(j==m) return n-i;
        
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=1+solve(i+1, j+1, s1, s2, dp);
        }
        else
        {
            return dp[i][j]=Math.min(
                    1+solve(i, j+1, s1, s2, dp), 
                    1+solve(i+1, j, s1, s2, dp)
                );
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna