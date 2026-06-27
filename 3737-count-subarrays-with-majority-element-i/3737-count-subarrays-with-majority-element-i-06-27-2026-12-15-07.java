class Solution {
    public int countMajoritySubarrays(int[] nums, int target) 
    {
        int n=nums.length;
        int[] freq=new int[2*n+1];
        freq[0+n]=1; //shifted by n in array of freq
        int res=0;
        int cumSum=0;
        int minIndex=0+n;
        for(int no: nums)
        {
            cumSum+=(no==target)?1:-1;
            int idx=cumSum+n;
            if(idx<minIndex) minIndex=idx; //shifted by n in array of freq
            for(int i=minIndex; i<idx; i++) res+=freq[i];
            freq[cumSum+n]++;
        }
        return res;
    }
}