class Solution 
{
    // DP Bottom-Up Approach 

    public int minDistance(String word1, String word2) 
    {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1]; //dp[i][j] -> mini operation to make from s1 to s2, if s1 len is i and s2 len in j;
        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=m; j++)
            {
                if(i==0||j==0) dp[i][j]=i+j;
                else if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else
                {
                    //insert 
                    int ins=1+dp[i][j-1];
                    //delete
                    int del=1+dp[i-1][j];
                    //replace
                    int rep=1+dp[i-1][j-1];

                    dp[i][j]=Math.min(ins, Math.min(del, rep));
                }
            }
        }
        return dp[n][m];
        
    }

    // private int solve(int i, int j, String s1, String s2, int[][] dp)
    // {
    //     if(i==0||j==0) return i+j;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     if(s1.charAt(i-1)==s2.charAt(j-1))
    //     {
    //         return dp[i][j]=0+solve(i-1, j-1, s1, s2, dp);
    //     }
    //     else
    //     {
    //         //insert 
    //         int ins=1+solve(i, j-1, s1, s2, dp);
    //         //delete
    //         int del=1+solve(i-1, j, s1, s2, dp);
    //         //replace
    //         int rep=1+solve(i-1, j-1, s1, s2, dp);

    //         return dp[i][j]=Math.min(ins, Math.min(del, rep));
    //     }
    // }
}