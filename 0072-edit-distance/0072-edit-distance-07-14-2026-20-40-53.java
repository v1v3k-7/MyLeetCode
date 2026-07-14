class Solution 
{
    // DP Top-Down Approach (Memo)
    int n, m;
    public int minDistance(String word1, String word2) 
    {
        n=word1.length();
        m=word2.length();
        int[][] dp=new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, word1, word2, dp);

    }
    private int solve(int i, int j, String s1, String s2, int[][] dp)
    {
        if(i==n || j==m) return (n-i) + (m-j); //if i OFB then remaining char of s2 will be add in s1 -> (m-j) operation, if j OFB then remaining char of s1 will get deleted(n-i operation) to make s1 from s2
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=0+solve(i+1, j+1, s1, s2, dp);
        }
        else
        {
            //insert 
            int ins=1+solve(i, j+1, s1, s2, dp);
            //delete
            int del=1+solve(i+1, j, s1, s2, dp);
            //replace
            int rep=1+solve(i+1, j+1, s1, s2, dp);

            return dp[i][j]=Math.min(ins, Math.min(del, rep));
        }
    }
}