class Solution 
{
    int n;
    boolean[][] palinDP;
    public int minCut(String s) 
    {
        n=s.length();
        palinDP=new boolean[n][n]; //dp[i][j] -> str[i:j] tak ka string palindrome hai ya nhi
        int[] cutDP=new int[n];
        Arrays.fill(cutDP, -1);
        for(int len=1; len<=n; len++)
        {
            for(int i=0; i<n-len+1; i++)
            {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j))
                {
                    if(len<=2) palinDP[i][j]=true; //len 1 & 2 ka string manage
                    else if(palinDP[i+1][j-1]) palinDP[i][j]=true; // 2 len se jyada ka string
                    //baki bedefault false hai hi
                }
            }
        }
        return solve(0, s, cutDP)-1;
    }

    private int solve(int i, String s, int[] dp)
    {
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];

        int cuts=Integer.MAX_VALUE;
        for(int j=i; j<n; j++)
        {
            if(palinDP[i][j])
            {
                cuts=Math.min(cuts, 1+solve(j+1, s, dp));
            }
        }
        return dp[i]=cuts;
    }
}