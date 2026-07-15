class Solution 
{
    int[][] dp;
    public int countSubstrings(String s) 
    {
        int n=s.length();
        dp=new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int count=0;
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(isPalin(i, j, s)==1) count++;
            }
        }
        return count;
    }
    private int isPalin(int i, int j, String s) //0->False, 1-> True
    {
        if(i>j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) 
        {
            return dp[i][j]=isPalin(i+1, j-1, s);
        }
        return 0;
    }
}