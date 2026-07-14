class Solution {
    public int longestStrChain(String[] words) 
    {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int n=words.length;
        int[] dp=new int[n]; //dp[i] -> Longest chain which ends with index i;
        dp[0]=1;
        int maxLen=1;
        for(int i=1; i<n; i++)
        {
            dp[i]=1;
            for(int j=0; j<i; j++)
            {
                if(isPredecessor(words[j], words[i]))
                {
                    dp[i]=Math.max(dp[j]+1, dp[i]);
                }
                if(dp[i]>maxLen) maxLen=dp[i];
            }
        }
        return maxLen;
    }

    // private int solve(int idx, String[] words, int prev, int[][] dp)
    // {
    //     if(idx==words.length) return 0;

    //     if(prev!=-1 && dp[idx][prev]!=-1) return dp[idx][prev];

    //     int pick=0;
    //     if(prev==-1 || isPredecessor(words[prev], words[idx]))
    //     {
    //         pick= 1 + solve(idx+1, words, idx, dp);
    //     }
    //     int noPick = solve(idx+1, words, prev, dp);

    //     if(prev!=-1) dp[idx][prev]=Math.max(pick, noPick);
    //     return Math.max(pick, noPick);
    // }


    private boolean isPredecessor(String a, String b) //a is subsequence of b or not; (b is bda string)
    {
        //a+1 = b and a subsequence hona chahiye b ka
        int m=a.length(), n=b.length();
        if(m+1!=n) return false;

        int i=0, j=0;
        while(i<m && j<n)
        {
            if(a.charAt(i)==b.charAt(j)) i++;
            j++;
        }
        return i==m;
    }
}