class Solution 
{
    int dp[][];
    public String longestPalindrome(String s) 
    {
        int n=s.length();
        dp=new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int maxLen=0;
        int x=-1, y=-1;
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(isPalindrome(s, i, j)==1)
                {
                    int len=j-i+1;
                    dp[i][j]=len;
                    if(len>maxLen)
                    {
                        maxLen=len;
                        x=i;
                        y=j;
                    }
                }
            }
        }
        return s.substring(x, y+1);
    }
    public int isPalindrome(String s, int i, int j)
    {
        if(i>=j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j]=isPalindrome(s, i+1, j-1);
        else return dp[i][j]=0;
    }
}