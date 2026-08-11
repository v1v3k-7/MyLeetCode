class Solution {
    public int missingInteger(int[] nums) 
    {
        int cur=nums[0];
        int sum=cur;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]==cur+1)
            {
                cur=nums[i];
                sum+=nums[i];
            }
            else break;
        }
        Arrays.sort(nums);
        for(int no: nums)
        {
            if(sum==no)
            {
                sum++;
            }
        }
        return sum;
    }
}