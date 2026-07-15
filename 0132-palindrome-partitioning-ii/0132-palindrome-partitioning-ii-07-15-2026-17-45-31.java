class Solution 
{
    int n;
    int[][] palinDP;
    public int minCut(String s) 
    {
        n=s.length();
        palinDP=new int[n][n]; //0->false, 1->true
        int[] cutDP=new int[n];
        Arrays.fill(cutDP, -1);
        for(int i=0; i<n; i++) 
        {
            Arrays.fill(palinDP[i], -1);
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
            if(isPalin(i, j, s)==1)
            {
                cuts=Math.min(cuts, 1+solve(j+1, s, dp));
            }
        }
        return dp[i]=cuts;
    }

    private int isPalin(int i, int j, String s)
    {
        if(i>j) return 1;
        if(palinDP[i][j]!=-1) return palinDP[i][j];

        if(s.charAt(i)==s.charAt(j)) return palinDP[i][j]=isPalin(i+1, j-1, s);
        else return palinDP[i][j]=0;
    }
}