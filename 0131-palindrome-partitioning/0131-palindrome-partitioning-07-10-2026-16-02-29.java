class Solution 
{
    int n;
    public List<List<String>> partition(String s) 
    {
        n=s.length();
        List<List<String>> res=new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int idx, String s, List<String> current, List<List<String>> res)
    {
        if(idx==n) res.add(new ArrayList<>(current));
        for(int end=idx; end<n; end++)
        {
            if(isPalin(s, idx, end))
            {
                current.add(s.substring(idx, end+1));
                backtrack(end+1, s, current, res);
                current.remove(current.size()-1);
            }
        }
    }
    
    private boolean isPalin(String s, int i, int j)
    {
        while(i<=j)
        {
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}