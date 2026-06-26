class Solution 
{
    public long countMajoritySubarrays(int[] nums, int target) 
    {
        HashMap<Long, Long> map=new HashMap<>();
        map.put(0L, 1L);
        long count=0;
        long validLeft=0;
        long sum=0;
        for(int no: nums)
        {
            long prev=sum;
            sum+=(no==target)?1:-1; //suppose converted all the nums longo -1 or +1;

            if(prev>sum) //mean target is not found, run even sum is decreased by one
            {
                validLeft-=map.getOrDefault(sum, 0L);
            }
            else //sum is increased by one
            {
                validLeft+=map.getOrDefault(sum-1, 0L);
            }
            count+=validLeft;
            map.merge(sum, 1L, Long::sum);
        }
        return count;
    }
}