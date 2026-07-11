class Solution {
    int n;
    public int maxUniqueSplit(String s) 
    {
        n=s.length();
        Set<String> set=new HashSet<>();
        return backtrack(0, s, 0, set);
    }
    private int backtrack(int idx, String s, int count, Set<String> set)
    {
        if(idx==n) return count;
        int res=0;
        for(int end=idx; end<n; end++)
        {
            String str=s.substring(idx, end+1);
            if(!set.contains(str))
            {
                set.add(str);
                int x=backtrack(end+1, s, count+1, set);
                if(x>res) res=x;
                set.remove(str);
            }
        }
        return res;
    }
}