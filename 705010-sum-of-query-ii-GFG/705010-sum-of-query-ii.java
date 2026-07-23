class Solution 
{
    List<Integer> querySum(int n, int arr[], int q, int queries[]) 
    {
        int[] segTree=new int[n*4];
        buildSegTree(0, segTree, 0, n-1, arr);
        List<Integer> res=new ArrayList<>();
        for(int i=0; i<q; i++)
        {
            int start=queries[2*i]-1; //minus one bcz array is one based indexing
            int end=queries[2*i+1]-1;
            int ans=query(start, end, 0, n-1, 0, segTree);
            res.add(ans);
        }
        return res;
    }
    public void buildSegTree(int idx, int segTree[], int l, int r, int[] arr)
    {
        if(l==r)
        {
            segTree[idx]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildSegTree(2*idx+1, segTree, l, mid, arr); //left side
        buildSegTree(2*idx+2, segTree, mid+1, r, arr); //right
        segTree[idx]=segTree[2*idx+1]+segTree[2*idx+2];
    }
    public int query(int start, int end, int l, int r, int idx, int[] segTree)
    {
        if(l>=start && r<=end) return segTree[idx];
        else if(l>end || r<start) return 0;
        //else part
        int mid=l+(r-l)/2;
        return query(start, end, l, mid, 2*idx+1, segTree) + query(start, end, mid+1, r, 2*idx+2, segTree);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna