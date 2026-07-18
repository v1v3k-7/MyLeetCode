class Solution {
    public int findGCD(int[] nums) 
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int no: nums)
        {
            if(no>max) max=no;
            if(no<min) min=no;
        }
        return gcd(min, max);
    }
    private int gcd(int a, int b)
    {
        return (b==0)?a:gcd(b, a%b);
    }
}