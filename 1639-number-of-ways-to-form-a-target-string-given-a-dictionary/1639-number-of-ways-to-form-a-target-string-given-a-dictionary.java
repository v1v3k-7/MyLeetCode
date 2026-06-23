class Solution {
    final int MOD=1_000_000_007;
    Integer[][] dp;
    public int numWays(String[] words, String target) 
    {
        int wordLen=words[0].length();
        int[][] charFreq=new int[wordLen][26];
        for(String word: words)
        {
            for(int i=0; i<wordLen; i++)
            {
                charFreq[i][word.charAt(i)-'a']++;
            }
        }
        dp=new Integer[target.length()][wordLen];
        return backtrack(words, target, 0, 0, charFreq);
    }
    public int backtrack(String[] words, String target, int wordIdx, int targetIdx, int[][] charFreq)
    {
        if(targetIdx==target.length()) return 1;
        if(wordIdx==words[0].length()) return 0;
        if(words[0].length()-wordIdx < target.length()-targetIdx) return 0;
        if(dp[targetIdx][wordIdx]!=null) return dp[targetIdx][wordIdx];

        int charIdx=target.charAt(targetIdx)-'a';
        int freq=charFreq[wordIdx][charIdx];
        long pick=(long)freq*backtrack(words, target, wordIdx+1, targetIdx+1, charFreq);
        long noPick=(long)backtrack(words, target, wordIdx+1, targetIdx, charFreq);
        return dp[targetIdx][wordIdx]=(int)((pick+noPick)%MOD);
    }
}