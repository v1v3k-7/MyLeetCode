class Solution 
{
    List<List<Integer>> res=new ArrayList<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        n=nums.length;
        backtrack(0, nums);
        return res;
    }

    private void backtrack(int idx, int[] nums)
    {
        if(idx==n)
        {
            List<Integer> list=new ArrayList<>();
            for(int no: nums) list.add(no);
            res.add(new ArrayList<>(list));
            return;
        }

        boolean[] set=new boolean[21]; //just to check duplicate like we were doing in set

        for(int i=idx; i<n; i++)
        {
            int no=(nums[i]+21)%21; //took mod for negative no;
            if(set[no]) continue;
            set[no]=true;

            swap(nums, idx, i);
            backtrack(idx+1, nums);
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