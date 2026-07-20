class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        int b=subarrayEqualOrLess(nums, k); //subarray with distinct integer of k or less than k
        int a=subarrayEqualOrLess(nums, k-1); //subarray with distinct integer of (k-1) or less than (k-1)
        return b-a;
    }
    public int subarrayEqualOrLess(int[] nums, int k)
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        int j=0, i=0;
        int n=nums.length;
        int count=0;
        while(j<n)
        {
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(map.size()>k)
            {
                //shrink the window
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }

            count+=j-i+1; //subarray count ending with j index
            j++;
        }
        return count;
    }
}