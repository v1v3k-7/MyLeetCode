class Solution {
    //sabko 1,-1 se fill
    //for any subarray count(target)<count(non target) mean it's majority element; count(left)<count(right)
    //here only -1 and 1 is present, so if count(left)<count(right)--> sum(left)<sum(right)
    public int countMajoritySubarrays(int[] nums, int target) 
    {
        int sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int count=0;
        for(int no: nums)
        {
            sum+=(no==target)?1:-1;
            
            for(Map.Entry<Integer,Integer> e: map.entrySet())
            {
                if(e.getKey()<sum) count+=e.getValue();
            }
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}