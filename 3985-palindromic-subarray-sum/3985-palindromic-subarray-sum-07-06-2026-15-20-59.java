class Solution 
{
    public long getSum(int[] nums) 
    {
        int m=nums.length;
        int[] t=transform(nums);
        int n=t.length;
        int[] palin=new int[n];
        int l=0, r=-1;
        for(int i=1; i<n-1; i++)
        {
            int len;
            if(i>r) len=0;
            else
            {
                int mir=l+(r-i);
                if(mir-palin[mir]>l)
                {
                    palin[i]=palin[mir];
                    continue;
                }
                else len=r-i;
            }
            while(i-len>=0 && i+len<n && t[i-len]==t[i+len]) len++;
            len--;
            palin[i]=len;
            if(i+len>r)
            {
                r=i+len;
                l=i-len;
            }
        }


        long[] prefix=new long[m+1];
        for(int i=0; i<m; i++) prefix[i+1]=prefix[i]+(long)nums[i];

        long maxSum=0L;
        for(int i=0; i<n; i++)
        {
            int len=palin[i];
            if(len==0) continue; //no palindrome
            int start=(i-len)/2;
            long sum=prefix[start+len]-prefix[start];
            if(sum>maxSum) maxSum=sum;
        }
        return maxSum;
    }

    public int[] transform(int[] nums)
    {
        int n=nums.length*2+1;
        int[] temp=new int[n];
        for(int i=0; i<nums.length; i++)
        {
            temp[i*2]=-1;
            temp[i*2+1]=nums[i];
        }
        temp[n-1]=-1;
        return temp;
    }
}