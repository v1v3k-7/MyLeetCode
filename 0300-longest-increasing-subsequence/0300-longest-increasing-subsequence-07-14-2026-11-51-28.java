class Solution {
    //Patience Sorting in LIS
    public int lengthOfLIS(int[] nums) 
    {
        int n=nums.length;
        List<Integer> sorted=new ArrayList(n);
        sorted.add(nums[0]);
        for(int i=1; i<n; i++)
        {
            int idx=findJustGreaterOrEqual(sorted, nums[i]);
            if(idx>=sorted.size()) sorted.add(nums[i]);
            else sorted.set(idx, nums[i]);
        }
        return sorted.size();
    }

    private int findJustGreaterOrEqual(List<Integer> sorted, int k) //Binary Search (logN)
    {
        int li=0;
        int hi=sorted.size()-1;
        while(li<=hi)
        {
            int mid=li+(hi-li)/2;
            if(sorted.get(mid)>=k)
            {
                hi=mid-1;
            }
            else
            {
                li=mid+1;
            }
        }
        return li;
    }
}