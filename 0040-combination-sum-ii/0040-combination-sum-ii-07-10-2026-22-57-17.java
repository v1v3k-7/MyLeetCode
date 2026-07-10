class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int idx, int target, int[] candidates, List<Integer> current, List<List<Integer>> res)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(current));
            return;
        }
        if(idx>=candidates.length) return;

        if(candidates[idx]<=target)
        {
            current.add(candidates[idx]);
            backtrack(idx+1, target-candidates[idx], candidates, current, res); //take case
            current.remove(current.size()-1);
        }
        while(idx+1<candidates.length && candidates[idx]==candidates[idx+1]) idx++;
        backtrack(idx+1, target, candidates, current, res); //noTake case
    }
}