class Solution {
    public int minInsertions(String s) 
    {
        int n=s.length();
        int dp[][]=new int[n][n]; //dp[i][j] -> str[i][j] me min kitne insert kr k palindrome bna skte hai
        for(int len=1; len<=n; len++)
        {
            for(int i=0; i<n-len+1; i++)
            {
                int j=i+len-1;
                if(i==j) dp[i][j]=0; //str len=0
                else
                {
                    if(s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1];
                    else dp[i][j]=1+Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}