class Solution {
    //Recursion + Memo
    public String longestPalindrome(String s) 
    {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int maxLen=0;
        int start=-1;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isPalin(i, j, s, dp)==1)
                {
                    if(j-i+1>maxLen)
                    {
                        maxLen=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
    private int isPalin(int i,  int j, String s, int[][] dp)
    {
        if(i>j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j))
        {
            return dp[i][j]=isPalin(i+1, j-1, s, dp);
        }
        return 0;
    }
}