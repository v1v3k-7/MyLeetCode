class Solution {
    public int beautifulSubsets(int[] nums, int k) 
    {
        return backtrack(0, k, nums, new ArrayList<>());
    }
    private int backtrack(int idx, int k, int[] nums, List<Integer> list)
    {
        int s=list.size();
        if(idx==nums.length)
        {
            if(s>=1) return 1;
            else return 0;
        }

        int take=0;
        if(s==0 || isTakePossible(list, nums[idx], k))
        {
            list.add(nums[idx]);
            take=backtrack(idx+1, k, nums, list);
            list.remove(s);
        }

        int noTake=backtrack(idx+1, k, nums, list);

        return take+noTake;
    }
    private boolean isTakePossible(List<Integer> list, int num, int k)
    {
        for(int no: list)
        {
            if(Math.abs(num - no)==k) return false;
        }
        return true;
    }
}