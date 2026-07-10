class Solution {
    public List<String> letterCombinations(String digits) 
    {
        List<String> res=new ArrayList<>();
        backtrack(0, digits, new StringBuilder(), res);
        return res;
    }
    private void backtrack(int idx, String digits, StringBuilder sb, List<String> res)
    {
        if(idx==digits.length())
        {
            res.add(sb.toString());
            return;
        }

        for(char ch: getChar(digits.charAt(idx)))
        {
            sb.append(ch);
            backtrack(idx+1, digits, sb, res);
            sb.deleteCharAt(sb.length()-1);

        }
    }
    private char[] getChar(char ch)
    {
        char[] res=new char[3];
        switch(ch)
        {
            case '2': 
                res=new char[]{'a', 'b', 'c'};
                break;
            case '3':
                res=new char[]{'d', 'e', 'f'};
                break;
            case '4':
                res=new char[]{'g','h','i'};
                break;
            case '5':
                res=new char[]{'j', 'k', 'l'};
                break;
            case '6': 
                res=new char[]{'m', 'n', 'o'};
                break;
            case '7':
                res=new char[]{'p', 'q', 'r', 's'};
                break;
            case '8':
                res=new char[]{'t','u','v'};
                break;
            case '9':
                res=new char[]{'w', 'x', 'y', 'z'};
                break;
        }
        return res;
    }
}