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

        //take case
        int takeSc=0;
        List<Character> used=new ArrayList<>();
        for(char ch: words[idx].toCharArray())
        {
            if(freq[ch-'a']==0)
            {
                takeSc=0;
                for(char c: used) freq[c-'a']++;
                break;
            }
            used.add(ch);
            takeSc+=score[ch-'a'];
            freq[ch-'a']--;
        }
        if(takeSc!=0)
        {
            takeSc=backtrack(idx+1, words, takeSc+sc);
            for(char ch: used)
            {
                freq[ch-'a']++;
            }
        }

        //noTake case
        int noTakeSc=backtrack(idx+1, words, sc);

        return Math.max(takeSc, noTakeSc);
    }
}