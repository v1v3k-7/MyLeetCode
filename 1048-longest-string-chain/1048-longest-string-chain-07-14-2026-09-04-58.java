class Solution {
    public int longestStrChain(String[] words) 
    {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int[][] dp=new int[words.length][words.length];
        for(int i=0; i<words.length; i++) Arrays.fill(dp[i], -1);
        return solve(0, words, -1, dp);
    }

    private int solve(int idx, String[] words, int prev, int[][] dp)
    {
        if(idx==words.length) return 0;

        if(prev!=-1 && dp[idx][prev]!=-1) return dp[idx][prev];

        int pick=0;
        if(prev==-1 || isPredecessor(words[prev], words[idx]))
        {
            pick= 1 + solve(idx+1, words, idx, dp);
        }
        int noPick = solve(idx+1, words, prev, dp);

        if(prev!=-1) dp[idx][prev]=Math.max(pick, noPick);
        return Math.max(pick, noPick);
    }


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