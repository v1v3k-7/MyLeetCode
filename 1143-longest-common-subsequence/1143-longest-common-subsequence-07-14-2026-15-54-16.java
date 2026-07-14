class Solution {
    //DP Bottom-Up Approach (Space Optimized)
    int n,m;
    public int longestCommonSubsequence(String text1, String text2) 
    {
        n=text1.length();
        m=text2.length();
        // int[][] dp=new int[n+1][m+1]; //dp[i][j] -> text1 k ith index tak and text2 k jth index tak me LCS ka length;
        // //dp[0][..] & dp[..][0] ko zero se fill
        int[] prev=new int[m+1]; //prev[0]=0
        for(int i=1; i<=n; i++)
        {
            int[] cur=new int[m+1]; 
            for(int j=1; j<=m; j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    // dp[i][j]=dp[i-1][j-1]+1;
                    cur[j]=prev[j-1]+1;
                }
                else
                {
                    // dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                    cur[j]=Math.max(prev[j], cur[j-1]);
                }
            }
            prev=cur;
        }
        return prev[m];
    }

    // private int solve(int i, int j, String text1, String text2, int[][] dp)
    // {
    //     if(i>=n || j>=m) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];

    //     if(text1.charAt(i)==text2.charAt(j))
    //     {
    //         return dp[i][j]=1+solve(i+1, j+1, text1, text2, dp);
    //     }
    //     else
    //     {
    //         int inc1=solve(i+1, j, text1, text2, dp);
    //         int inc2=solve(i, j+1, text1, text2, dp);
    //         return dp[i][j]=Math.max(inc1, inc2);
    //     }
    // }
}