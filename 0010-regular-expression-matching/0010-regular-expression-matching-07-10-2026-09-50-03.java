class Solution {
    public boolean isMatch(String s, String p) 
    {
        return backtrack(s, p);
    }
    private boolean backtrack(String s, String p)
    {
        if(p.length()==0)
        {
            if(s.length()==0) return true;
            else return false;
        }

        boolean firstMatch = (s.length()>0) && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        if(p.length()>1 && p.charAt(1)=='*')
        {
            boolean notTake=backtrack(s, p.substring(2));
            boolean take=firstMatch && backtrack(s.substring(1), p);
            return notTake || take;
        }
        else
        {
            return firstMatch && backtrack(s.substring(1), p.substring(1));
        }
    }
}