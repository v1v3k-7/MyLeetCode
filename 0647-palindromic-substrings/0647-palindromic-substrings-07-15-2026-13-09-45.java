class Solution 
{
    public int countSubstrings(String s) 
    {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int count=0;
        for(int L=1; L<=n; L++)
        {
            for(int i=0; i+L-1<n; i++)
            {
                int j=i+L-1;
                if(i==j) dp[i][j]=true; //single length string
                else if(i+1==j) dp[i][j]=s.charAt(i)==s.charAt(j); //two length string
                else //more then two length sting (generic)
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) dp[i][j]=true;
                    else dp[i][j]=false;
                }

                if(dp[i][j]) count++;
            }
        }
        return count;
    }
}