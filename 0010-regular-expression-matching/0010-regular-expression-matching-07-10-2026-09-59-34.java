class Solution {
    public boolean isMatch(String s, String p) 
    {
        return backtrack(s, p, 0, 0);
    }

    private boolean backtrack(String s, String p, int sIdx, int pIdx)
    {
        if(p.length()<=pIdx)
        {
            if(s.length()<=sIdx) return true;
            else return false;
        }

        boolean firstMatch = (sIdx<s.length()) && (s.charAt(sIdx)==p.charAt(pIdx) || p.charAt(pIdx)=='.');

        if(p.length()>pIdx+1 && p.charAt(pIdx+1)=='*')
        {
            boolean notTake=backtrack(s, p, sIdx, pIdx+2);
            boolean take=firstMatch && backtrack(s, p, sIdx+1, pIdx);
            return notTake || take;
        }
        else
        {
            return firstMatch && backtrack(s, p, sIdx+1, pIdx+1);
        }
    }
}