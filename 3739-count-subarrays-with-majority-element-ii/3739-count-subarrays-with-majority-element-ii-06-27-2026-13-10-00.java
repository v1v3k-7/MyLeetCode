class Solution {
    public long countMajoritySubarrays(int[] nums, int target) 
    {
        int n=nums.length;
        long[] freq=new long[n*2+1]; //to store freq of sum act like map
        freq[0+n]=1; //store sum=0-> 1 freq (addded +n bcz shifted by n)
        long sum=0, res=0;
        long validLeft=0;
        for(int no: nums)
        {
            int idx=(int)sum+n; //shifted by n;
            if(no==target)
            {
                validLeft+=freq[idx];
                sum++;
            }
            else
            {
                validLeft-=freq[idx-1];
                sum--;
            }
            res+=validLeft;
            freq[(int)sum+n]+=1;
        }
        return res;
    }
}