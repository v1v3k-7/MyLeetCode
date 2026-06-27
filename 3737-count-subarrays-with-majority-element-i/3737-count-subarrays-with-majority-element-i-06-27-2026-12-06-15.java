class Solution {
    public int countMajoritySubarrays(int[] nums, int target) 
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int res=0;
        int cumSum=0;
        for(int no: nums)
        {
            cumSum+=(no==target)?1:-1;
            for(Map.Entry<Integer, Integer> e: map.entrySet())
            {
                if(e.getKey()<cumSum) res+=e.getValue();
            }
            map.merge(cumSum, 1, Integer::sum);
        }
        return res;
    }
}