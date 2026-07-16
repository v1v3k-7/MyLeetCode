class Solution {
    public long gcdSum(int[] nums) 
    {
        int n=nums.length;
        int mx=Integer.MIN_VALUE;
        int[] arr=new int[n];
        for(int i=0; i<n; i++)
        {
            if(nums[i]>mx) mx=nums[i];
            arr[i]=findGCD(nums[i], mx);;
        }
        long res=0;
        Arrays.sort(arr);
        int i=0, j=n-1;
        while(i<j)
        {
            res+=(long)findGCD(arr[j], arr[i]);;
            i++;
            j--;
        }
        return res;
    }
    private int findGCD(int a, int b)
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}