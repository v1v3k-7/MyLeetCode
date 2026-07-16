class Solution {
    public long gcdSum(int[] nums) 
    {
        int n=nums.length;
        int mx=Integer.MIN_VALUE;
        int[] arr=new int[n];
        for(int i=0; i<n; i++)
        {
            if(nums[i]>mx) mx=nums[i];
            int gcd=findGCD(nums[i], mx);
            arr[i]=gcd;
        }
        long res=0;
        Arrays.sort(arr);
        int i=0, j=n-1;
        while(i<j)
        {
            int gcd=findGCD(arr[j], arr[i]);
            res+=(long)gcd;
            i++;
            j--;
        }
        return res;
    }
    private int findGCD(int a, int b)
    {
        if(b>a) return findGCD(b, a);
        return (b==0)?a:findGCD(b, a%b);
    }
}