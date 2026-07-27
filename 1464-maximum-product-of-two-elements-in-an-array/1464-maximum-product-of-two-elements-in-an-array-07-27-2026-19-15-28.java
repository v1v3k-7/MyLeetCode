class Solution 
{
    public int maxProduct(int[] nums) 
    {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        for(int no: nums)
        {
            if(no>max1)
            {
                max2=max1;
                max1=no;
            }
            else if(no>max2)
            {
                max2=no;
            }
        }
        return (max1-1)*(max2-1);
    }
}