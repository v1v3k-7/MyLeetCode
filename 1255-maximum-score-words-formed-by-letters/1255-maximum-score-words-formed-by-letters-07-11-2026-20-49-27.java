class Solution {
    int[] score;
    int[] freq=new int[26];
    public int maxScoreWords(String[] words, char[] letters, int[] score) 
    {
        this.score=score;
        HashMap<Character, Integer> letterMap=new HashMap<>();
        for(char ch: letters)
        {
            freq[ch-'a']++;
        }
        return backtrack(0, words, 0);
    }
    private int backtrack(int idx, String[] words, int sc)
    {
        int n=words.length;
        if(idx==n) return sc;

        String word=words[idx];
        //take case
        int takeSc=0;
        int j=0;
        int s=word.length();
        while(j<s)
        {
            char ch=word.charAt(j);
            if(freq[ch-'a']==0)
            {
                takeSc=0;
                break;
            } 
            takeSc+=score[ch-'a'];
            freq[ch-'a']--;
            j++;
        }
        if(j==s)
        {
            takeSc=backtrack(idx+1, words, takeSc+sc);
        }
        //backtrack if take and if failed at middle to jitna letters lie the usko wapas freq me add
        j--;
        while(j>=0)
        {
            char ch=word.charAt(j);
            freq[ch-'a']++;
            j--;
        }

        //noTake case
        int noTakeSc=backtrack(idx+1, words, sc);

        return Math.max(takeSc, noTakeSc);
    }
}