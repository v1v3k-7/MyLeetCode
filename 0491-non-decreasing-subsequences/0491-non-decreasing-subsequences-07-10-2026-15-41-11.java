class Solution {
    int n;
    public List<List<Integer>> findSubsequences(int[] nums) 
    {
        n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int[] nums, int idx, List<Integer> current, List<List<Integer>> res)
    {
        if(current.size()>1) 
        {
            res.add(new ArrayList<>(current));
        }

        Set<Integer> set=new HashSet<>();
        for(int i=idx; i<n; i++)
        {
            if((current.isEmpty() || current.get(current.size()-1)<=nums[i]) && !set.contains(nums[i]))
            {
                current.add(nums[i]);
                backtrack(nums, i+1, current, res);
                current.remove(current.size()-1);

                set.add(nums[i]);
            }

        }
    }
}