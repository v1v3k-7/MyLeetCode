class Solution {
    int dp[][]=new int[21][21];

    public boolean isMatch(String s, String p) 
    {
        for(int i=0; i<21; i++) Arrays.fill(dp[i], -1);
        int x=backtrack(s, p, 0, 0);
        return x==1;
    }

    private int backtrack(String s, String p, int sIdx, int pIdx)
    {
        if(p.length()<=pIdx)
        {
            if(s.length()<=sIdx) return dp[sIdx][pIdx]=1;
            else return dp[sIdx][pIdx]=0;
        }
        if(dp[sIdx][pIdx]!=-1) return dp[sIdx][pIdx];

        boolean firstMatch = (sIdx<s.length()) && (s.charAt(sIdx)==p.charAt(pIdx) || p.charAt(pIdx)=='.');

        if(p.length()>pIdx+1 && p.charAt(pIdx+1)=='*')
        {
            int noTake=backtrack(s, p, sIdx, pIdx+2);
            int take=0;
            if(firstMatch)
            {
                take=backtrack(s, p, sIdx+1, pIdx);
            }
            if(noTake==1||take==1) return dp[sIdx][pIdx]=1;
            else return dp[sIdx][pIdx]=0;
        }
        else
        {
            if(firstMatch)
            {
                return dp[sIdx][pIdx]=backtrack(s, p, sIdx+1, pIdx+1);
            }
            else return dp[sIdx][pIdx]=0;
        }
    }
}