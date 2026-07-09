class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) 
    {
        backtrack(nums, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums, List<Integer> current)
    {
        int n=nums.length;
        if(current.size()==n)
        {
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(current.contains(nums[i])) continue;

            current.add(nums[i]);
            backtrack(nums, current);
            current.remove(current.size()-1);
        }
    }
}