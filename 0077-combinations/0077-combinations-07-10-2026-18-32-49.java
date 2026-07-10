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
        if(current.size()==k)
        {
            res.add(new ArrayList<>(current));
            return;
        }
        if(idx==n+1) return;

        if(current.size()<k)
        {
            current.add(idx);
            backtrack(idx+1, n, k, current, res); //pick case
            current.remove(current.size()-1);
        }
        backtrack(idx+1, n, k, current, res); //no pick case
    }
}