class Solution {
    int n;
    public List<List<String>> partition(String s) 
    {
        n=s.length();
        boolean[][] dp=new boolean[n][n]; //dp[i][j] -> str[i:j] tak k string me palidrome hai ya nhi
        for(int len=1; len<=n; len++)
        {
            for(int i=0; i<n-len+1; i++)
            {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j))
                {
                    if(len<=2) dp[i][j]=true; //1 & 2 length ka string handle ho gya.
                    else if(dp[i+1][j-1]) dp[i][j]=true;
                    //wran false hai hi bydefault
                }
            }
        }
        List<List<String>> res=new ArrayList<>();
        backtrack(0, s, res, new ArrayList<>(), dp);
        return res;
    }
    private void backtrack(int i, String s, List<List<String>> res, List<String> current, boolean[][] dp)
    {
        if(i==n) res.add(new ArrayList<>(current));
        for(int j=i; j<n; j++)
        {
            if(dp[i][j])
            {
                current.add(s.substring(i, j+1));
                backtrack(j+1, s, res, current, dp);
                current.remove(current.size()-1);
            }
        }
    }
}