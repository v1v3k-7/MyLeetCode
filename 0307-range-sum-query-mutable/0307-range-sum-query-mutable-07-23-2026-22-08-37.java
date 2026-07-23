class NumArray 
{
    int[] segTree;
    int n;
    public NumArray(int[] nums) 
    {
        n=nums.length;
        segTree=new int[n*4];
        buildST(nums, 0, 0, n-1);
    }
    private void buildST(int[] arr, int idx, int l, int r)
    {
        if(l==r)
        {
            segTree[idx]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildST(arr, 2*idx+1, l, mid);
        buildST(arr, 2*idx+2, mid+1, r);
        segTree[idx]=segTree[2*idx+1]+segTree[2*idx+2];
    }
    
    public void update(int index, int val) 
    {
        updateSeg(index, val, 0, 0, n-1);
    }
    private void updateSeg(int target, int val, int node, int l, int r)
    {
        if(l==r)
        {
            segTree[node]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(target<=mid) //move left
        {
            updateSeg(target, val, 2*node+1, l, mid);
        }
        else //move right
        {
            updateSeg(target, val, 2*node+2, mid+1, r);
        }
        segTree[node]=segTree[2*node+1]+segTree[2*node+2];
    }
    
    public int sumRange(int left, int right) 
    {
        return rangeSumQuery(0, left, right, 0, n-1);
    }
    private int rangeSumQuery(int idx, int start, int end, int l, int r)
    {
        if(l>end || r<start) return 0; //outside range
        if(l>=start && r<=end) return segTree[idx]; //completely inside range
        
        //overlappig case
        int mid=l+(r-l)/2;
        return rangeSumQuery(2*idx+1, start, end, l, mid) + rangeSumQuery(2*idx+2, start, end, mid+1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val); 
 * int param_2 = obj.sumRange(left,right);
 */