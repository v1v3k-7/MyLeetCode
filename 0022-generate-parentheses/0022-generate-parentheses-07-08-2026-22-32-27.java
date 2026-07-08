class Solution {
    public List<String> generateParenthesis(int n) 
    {
        List<String> res=new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }
    private void backtrack(int n, int close, int open, StringBuilder sb, List<String> res)
    {
        if(close>open || open>n || close>n) return;
        if(close==n && open==close)
        {
            res.add(sb.toString());
            return;
        }

        sb.append('(');
        backtrack(n, close, open+1, sb, res); //trust ab ye aage ka sab kr k le aayega ( wala
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        backtrack(n, close+1, open, sb, res); //trust ab ye aage ka sab kr k le aayega ) wala
        sb.deleteCharAt(sb.length()-1);
    }
}