class Solution {
    public int countMajoritySubarrays(int[] nums, int target) 
    {
        int n=nums.length;
        int[] freq=new int[2*n+1];
        freq[0+n]=1; //shifted by n in array of freq. sum=0 ki freq 1 dal dia hmne
        int res=0;
        int cumSum=0;
        int validLeft=0;
        for(int no: nums)
        {
            int idx=cumSum+n; //shifted by n. to hum freq array me dekh rhe hain
            if(no==target) //mtlb cumSum ek bdhne wala hai
            {
                validLeft+=freq[idx];
                cumSum++;
            }
            else //mtlb cumSum ek ghntne wala hai; to hum isko hta denge validLeft se
            {
                validLeft-=freq[idx-1];
                cumSum--;
            }
            res+=validLeft;

            freq[cumSum+n]++;
        }
        return res;
    }
}