class Solution {
    public String stoneGameIII(int[] stoneValue) 
    {
        int n=stoneValue.length;
        // Integer[] dp=new Integer[n];
        int[] dp=new int[n+1]; //dp[i] -> i se last tak stones hai to differece (Alice-Bob)
        dp[n]=0;
        for(int i=n-1; i>=0; i--)
        {
            dp[i]=stoneValue[i]-dp[i+1];
            if(i+1<n)
            {
                dp[i]=Math.max(dp[i], stoneValue[i]+stoneValue[i+1]-dp[i+2]);
            }
            if(i+2<n)
            {
                dp[i]=Math.max(dp[i], stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[i+3]);
            }
        }
        if(dp[0]>0) return "Alice";
        else if(dp[0]<0) return "Bob";
        else return "Tie";  
    }
    // private int solve(int idx, int[] stoneValue, Integer[] dp)
    // {
    //     int n=stoneValue.length;
    //     if(idx>=n) return 0;
    //     if(dp[idx]!=null) return dp[idx];
    //     int res=stoneValue[idx]-solve(idx+1, stoneValue, dp);
    //     if(idx+1<n) res=Math.max(res, stoneValue[idx]+stoneValue[idx+1]-solve(idx+2, stoneValue, dp));
    //     if(idx+2<n) res=Math.max(res, stoneValue[idx]+stoneValue[idx+1]+stoneValue[idx+2]-solve(idx+3, stoneValue, dp));
    //     return dp[idx]=res;
    // }
}