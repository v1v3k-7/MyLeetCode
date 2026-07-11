class Solution {
    int n;
    public int maxUniqueSplit(String s) 
    {
        n=s.length();
        Set<String> set=new HashSet<>();
        return backtrack(0, s, set);
    }
    private int backtrack(int idx, String s, Set<String> set)
    {
        if(idx==n) return 0;
        int res=-1;
        for(int end=idx; end<n; end++)
        {
            String str=s.substring(idx, end+1);
            if(set.add(str))
            {
                res=Math.max(res, 1+backtrack(end+1, s, set));
                set.remove(str);
            }
        }
        return res;
    }
}