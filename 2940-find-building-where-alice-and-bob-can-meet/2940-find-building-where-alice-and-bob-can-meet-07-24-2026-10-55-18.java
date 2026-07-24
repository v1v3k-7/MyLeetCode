class Solution {
    int segTree[];
    private void buildST(int[] heights, int i, int l, int r)
    {
        if(l==r) 
        {
            segTree[i]=l;
            return;
        }
        int mid=l+(r-l)/2;
        buildST(heights, 2*i+1, l, mid);
        buildST(heights, 2*i+2, mid+1, r);
        int leftMaxIdx=segTree[2*i+1];
        int rightMaxIdx=segTree[2*i+2];
        if(heights[leftMaxIdx]>=heights[rightMaxIdx]) segTree[i]=leftMaxIdx;
        else segTree[i]=rightMaxIdx;
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) 
    {
        int n=heights.length;
        segTree=new int[4*n];
        buildST(heights, 0, 0, n-1); //first build segment tree

        int[] res=new int[queries.length];
        for(int i=0; i<queries.length; i++)
        {
            int a=queries[i][0], b=queries[i][1];
            if (a > b) //b is always greater index than a
            {
                int temp = a;
                a = b;
                b = temp;
            }
            if(a==b || heights[b]>heights[a]) 
            {
                res[i]=b;
                continue;
            }
            //find first element jo heights[a] se bda ho or index b+1 k just bda hoga
            int low=b+1, high=n-1;
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                int idx=RMIQ(low, mid, 0, 0, n-1, heights);
                if(idx!=-1 && heights[idx]>heights[a]) high=mid-1;
                else low=mid+1;
            }
            res[i]=(low<n)?low:-1;
        }
        return res;
    }
     
    private int RMIQ(int start, int end, int i, int l, int r, int[] heights)
    {
        if(r<start || l>end) return -1;
        if(l>=start && r<=end) return segTree[i];

        int mid=l+(r-l)/2;
        int leftMaxIdx=RMIQ(start, end, 2*i+1, l, mid, heights);
        int rightMaxIdx=RMIQ(start, end, 2*i+2, mid+1, r, heights);

        if(leftMaxIdx==-1) return rightMaxIdx;
        if(rightMaxIdx==-1) return leftMaxIdx;

        if(heights[leftMaxIdx]>=heights[rightMaxIdx]) return leftMaxIdx;
        else return rightMaxIdx;
    }
}