class Solution 
{
    int n;
    boolean[][] palinDP;
    public int minCut(String s) 
    {
        n=s.length();
        palinDP=new boolean[n][n]; //dp[i][j] -> str[i:j] tak ka string palindrome hai ya nhi
        for(int len=1; len<=n; len++)
        {
            for(int i=0; i<n-len+1; i++)
            {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j))
                {
                    if(len<=2) palinDP[i][j]=true; //len 1 & 2 ka string manage
                    else palinDP[i][j]=palinDP[i+1][j-1]; // 2 len se jyada ka string
                    //baki bedefault false hai hi
                }
            }
        }
        int[] cutDP=new int[n]; //dp[i] -> str[0:i] tak k string me min kitn e palindromic cut lga skte hai
        for(int i=1; i<n; i++)
        {
            if(palinDP[0][i]) cutDP[i]=0; // no cut required
            else
            {
                cutDP[i]=Integer.MAX_VALUE;
                for(int cut=0; cut<i; cut++)
                {
                    if(palinDP[cut+1][i])
                        cutDP[i]=Math.min(1+cutDP[cut], cutDP[i]);
                }
            }
        }
        return cutDP[n-1];
    }
}