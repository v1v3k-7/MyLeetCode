class Solution {
    public String longestPalindrome(String s) 
    {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int maxLen=0;
        int x=-1, y=-1;
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(dp[i][j]!=-1) continue;
                if(isPalindrome(s, i, j))
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
    public boolean isPalindrome(String s, int i, int j)
    {
        if(i>=j) return true;
        if(s.charAt(i)==s.charAt(j)) return isPalindrome(s, i+1, j-1);
        else return false;
    }
}