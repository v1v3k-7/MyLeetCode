class Solution {
    int[] score;
    public int maxScoreWords(String[] words, char[] letters, int[] score) 
    {
        this.score=score;
        HashMap<Character, Integer> letterMap=new HashMap<>();
        for(char ch: letters)
        {
            letterMap.put(ch, letterMap.getOrDefault(ch, 0)+1);
        }
        return backtrack(0, words, letterMap, 0);
    }
    private int backtrack(int idx, String[] words, HashMap<Character, Integer> letterMap, int sc)
    {
        int n=words.length;
        if(idx==n) return sc;

        //take case
        int takeSc=0;
        List<Character> used=new ArrayList<>();
        for(char ch: words[idx].toCharArray())
        {
            if(!letterMap.containsKey(ch))
            {
                takeSc=0;
                for(char c: used) letterMap.put(c, letterMap.getOrDefault(c, 0)+1); 
                break;
            }
            int cnt=letterMap.get(ch);
            used.add(ch);
            takeSc+=score[ch-'a'];
            letterMap.put(ch, cnt-1);
            if(cnt==1) letterMap.remove(ch);
        }
        if(takeSc!=0)
        {
            takeSc=backtrack(idx+1, words, letterMap, takeSc+sc);
            for(char ch: used)
            {
                letterMap.put(ch, letterMap.getOrDefault(ch, 0)+1);
            }
        }

        //noTake case
        int noTakeSc=backtrack(idx+1, words, letterMap, sc);

        return Math.max(takeSc, noTakeSc);
    }
}