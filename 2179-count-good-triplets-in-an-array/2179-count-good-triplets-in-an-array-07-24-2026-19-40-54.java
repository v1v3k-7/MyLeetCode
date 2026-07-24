class Solution {
    private void updateSeg(int i, int l, int r, int nums2_idx, int[] segTree)
    {
        if(l==r)
        {
            segTree[i]=1;
            return;
        }
        int mid=l+(r-l)/2;
        if(nums2_idx<=mid) updateSeg(2*i+1, l, mid, nums2_idx, segTree); //left
        else updateSeg(2*i+2, mid+1, r, nums2_idx, segTree); //right

        segTree[i]=segTree[2*i+1]+segTree[2*i+2];
    }
    private int querySeg(int start, int end, int i, int l, int r, int[] segTree)
    {
        if(l>end || r<start) return 0;
        if(l>=start && r<=end) return segTree[i];
        int mid=l+(r-l)/2;
        int left=querySeg(start, end, 2*i+1, l, mid, segTree);
        int right=querySeg(start, end,2*i+2, mid+1, r, segTree);
        return left+right;
    }
    public long goodTriplets(int[] nums1, int[] nums2) 
    {
        int n=nums1.length;
        int[] segTree=new int[4*n]; //intially sabka freq 0 hai;

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++) map.put(nums2[i], i);

        long res=0;

        updateSeg(0, 0, n-1, map.get(nums1[0]), segTree); 
        for(int i=1; i<n-1; i++)
        {
            int num2_idx=map.get(nums1[i]);
            int common_left=querySeg(0, num2_idx, 0, 0, n-1, segTree); 
            int notCommon_left=i-common_left;
            int elementAfterNum2_idx=(n-1)-num2_idx;
            int common_right=elementAfterNum2_idx-notCommon_left;
            res+=(long)common_left*(long)common_right;

            updateSeg(0, 0, n-1, map.get(nums1[i]), segTree);
        }
        
        return res;

    }
}