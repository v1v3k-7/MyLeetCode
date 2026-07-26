class Solution 
{
    private void update(int idx, int val, int i, int l, int r, int[] segTree)
    {
        if(l==r) 
        {
            segTree[i]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(idx<=mid)
        {
            update(idx, val, 2*i+1, l, mid, segTree);
        }
        else
        {
            update(idx, val, 2*i+2, mid+1, r, segTree);
        }
        segTree[i]=Math.max(segTree[2*i+1], segTree[2*i+2]);
    }

    private int querySeg(int start, int end, int i, int l, int r, int[] segTree)
    {
        if(l>end || r<start) return Integer.MIN_VALUE;
        if(l>=start && r<=end) return segTree[i];
        int mid=l+(r-l)/2;
        int left=querySeg(start, end, 2*i+1, l, mid, segTree);
        int right=querySeg(start, end, 2*i+2, mid+1, r, segTree);
        return Math.max(left, right);
    }

    public List<Boolean> getResults(int[][] queries) 
    {
        List<Boolean> res=new ArrayList<>();
        TreeSet<Integer> set=new TreeSet<>(); //to store obstacles
        set.add(0);
        int n=50000;
        int[] segTree=new int[4*(n+1)]; 
        for(int query[]: queries)
        {
            int type=query[0];
            int x=query[1];
            if(type==1) 
            {
                int prev=set.lower(x);
                Integer next=set.higher(x);
                update(x, x-prev, 0, 0, n, segTree);
                if(next!=null)
                {
                    update(next, next-x, 0, 0, n, segTree);
                }
                set.add(x);
                continue;
            }
            int sz=query[2];
            if(x<sz)
            {
                res.add(false);
                continue;
            }
            int lastObstacle=set.floor(x);
            int lastGap=x-lastObstacle;
            int maxGap=querySeg(0, lastObstacle, 0, 0, n, segTree);
            int best=Math.max(maxGap, lastGap);
            if(best>=sz) res.add(true);
            else res.add(false);
        }
        return res;
    }
}