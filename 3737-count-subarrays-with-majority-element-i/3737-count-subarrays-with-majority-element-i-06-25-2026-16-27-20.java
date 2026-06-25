class Solution {
    public int countMajoritySubarrays(int[] nums, int target) 
    {
        int n=nums.length;
        int[] pref=new int[n+1]; //prefix of target count excluding self
        for(int i=1; i<n+1; i++) pref[i]=pref[i-1] + ((nums[i-1]==target)?1:0);

        int ans=0;
        for(int l=0; l<n; l++)
        {
            for(int r=l; r<n; r++)
            {
                int len=r-l+1;
                int count=pref[r+1]-pref[l];
                if(count>len/2) ans++;
            }
        }
        return ans;
    }
}