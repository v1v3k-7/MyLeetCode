class Solution {
    //DP Bottom-Up
    public String longestPalindrome(String s) 
    {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        
        int maxLen=0;
        int start=-1;
        for(int len=1; len<=n; len++)
        {
            for(int i=0; i+len-1<n; i++)
            {
                int j=i+len-1;
                if(i==j) dp[i][j]=true; //1 length string
                else if(i+1==j) dp[i][j]=s.charAt(i)==s.charAt(j); //2 length string
                else //more than 2 length string
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) dp[i][j]=true;
                    else dp[i][j]=false;
                }

                if(dp[i][j])
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
}