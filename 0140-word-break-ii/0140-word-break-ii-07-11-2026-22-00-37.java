class Solution 
{
    int n;
    public List<String> wordBreak(String s, List<String> wordDict) 
    {
        n=s.length();
        HashSet<String> set=new HashSet<>();
        List<String> res=new ArrayList<>();
        for(String str: wordDict) set.add(str);
        backtrack(0, s, res, new StringBuilder(), set);
        return res;
    }
    public void backtrack(int start, String s, List<String> res, StringBuilder sb, HashSet<String> set)
    {
        if(start==n) res.add(sb.toString().trim());

        for(int end=start; end<n; end++)
        {
            if(set.contains(s.substring(start, end+1)))
            {
                sb.append(' ');
                sb.append(s.substring(start, end+1));

                backtrack(end+1, s, res, sb, set);

                int wordLen=end-start+1;
                sb.delete(sb.length() - wordLen -1, sb.length()); //(start-end+1) => length of word and -1 for space
            }
        }
    }
}