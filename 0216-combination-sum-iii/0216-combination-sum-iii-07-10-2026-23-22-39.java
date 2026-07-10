class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int idx, int n, int k, List<Integer> current, List<List<Integer>> res)
    {
        if(n==0)
        {
            if(current.size()==k) res.add(new ArrayList<>(current));
            return;
        }
        if(current.size()>k) return;
        if(idx>=10) return;

        if(idx<=n)
        {
            current.add(idx);
            backtrack(idx+1, n-idx, k, current, res);
            current.remove(current.size()-1);
        }
        backtrack(idx+1, n, k, current, res);
    }
}