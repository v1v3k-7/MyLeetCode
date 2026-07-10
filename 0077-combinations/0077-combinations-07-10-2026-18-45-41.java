class Solution 
{
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }
    public void backtrack(int idx, int n, int k, List<Integer> current, List<List<Integer>> res)
    {
        if(k==0)
        {
            res.add(new ArrayList<>(current));
            return;
        }
        if(idx>=n+1) return;
        
        current.add(idx);
        backtrack(idx+1, n, k-1, current, res);
        current.remove(current.size()-1);

        backtrack(idx+1, n, k, current, res);

    }
}