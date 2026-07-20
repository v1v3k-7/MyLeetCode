class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        int i=0, i_largest=0;
        int n=nums.length;
        int ans=0;
        for(int j=0; j<n; j++)
        {
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(map.size()>k)
            {
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
                i_largest=i;
            }

            while(map.get(nums[i])>1)
            {
                map.put(nums[i], map.get(nums[i])-1);
                i++;
            }
            
            if(map.size()==k) ans+=1+i-i_largest;
        }
        return ans;
    }
}