class Solution 
{
    public int countMajoritySubarrays(int[] nums, int target) 
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int count=0;
        int validLeft=0;
        int sum=0;
        for(int no: nums)
        {
            int prev=sum;
            sum+=(no==target)?1:-1; //suppose converted all the nums into -1 or +1;

            if(prev>sum) //mean target is not found, run even sum is decreased by one
            {
                validLeft-=map.getOrDefault(sum, 0);
            }
            else //sum is increased by one
            {
                validLeft+=map.getOrDefault(sum-1, 0);
            }
            count+=validLeft;
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}