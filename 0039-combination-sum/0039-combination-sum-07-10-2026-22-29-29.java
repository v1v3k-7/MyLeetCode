class Solution {
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        n=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int idx, int[] candidates, int target, List<Integer> current, List<List<Integer>> res)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(current));
            return;
        }
        if(idx>=n) return;

        if(candidates[idx]<=target)
        {
            current.add(candidates[idx]);   
            backtrack(idx, candidates, target-candidates[idx], current, res); //take case
            current.remove(current.size()-1);
        }
        backtrack(idx+1, candidates, target, current, res); //noTake case
    }
}