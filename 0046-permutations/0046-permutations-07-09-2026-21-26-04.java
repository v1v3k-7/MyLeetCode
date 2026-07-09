class Solution {
    
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(0, nums, res);
        return res;
    }
    private void backtrack(int idx, int[] nums, List<List<Integer>> res)
    {
        int n=nums.length;
        if(idx==n)
        {
            List<Integer> list = new ArrayList<>();
            for (int x : nums) {
                list.add(x);
            }
            res.add(list);
            return;
        }
        for(int i=idx; i<n; i++)
        {
            swap(nums, idx, i);
            backtrack(idx+1, nums, res);
            swap(nums, idx, i);
        }
    }
    private void swap(int[] nums, int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}