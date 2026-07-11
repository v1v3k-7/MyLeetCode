class Solution {
    public int beautifulSubsets(int[] nums, int k) 
    {
        return backtrack(0, k, nums, new HashMap<>());
    }
    private int backtrack(int idx, int k, int[] nums, HashMap<Integer, Integer> map)
    {
        int s=map.size();
        if(idx==nums.length)
        {
            if(s>=1) return 1;
            else return 0;
        }

        int take=0;
        if(s==0 || (!map.containsKey(nums[idx]-k) && !map.containsKey(nums[idx]+k)) )
        {
            map.put(nums[idx], map.getOrDefault(nums[idx], 0)+1);
            take=backtrack(idx+1, k, nums, map);
            map.put(nums[idx], map.getOrDefault(nums[idx], 0)-1);
            if(map.get(nums[idx])==0) map.remove(nums[idx]);
        }

        int noTake=backtrack(idx+1, k, nums, map);

        return take+noTake;
    }
}