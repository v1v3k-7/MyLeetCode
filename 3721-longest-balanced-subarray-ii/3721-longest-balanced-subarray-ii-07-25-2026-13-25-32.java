class Solution 
{
    int[] segMin, segMax, lazy;

    private void propagate(int i, int l, int r)
    {
        if(lazy[i]!=0)
        {
            segMin[i]+=lazy[i];
            segMax[i]+=lazy[i];
            if(l!=r)
            {
                lazy[2*i+1]+=lazy[i];
                lazy[2*i+2]+=lazy[i];
            }
            lazy[i]=0;
        }
    }

    private void updateRange(int start, int end, int i, int l, int r, int val)
    {
        propagate(i, l, r); //if lazy[i]!=0
        if(r<start || l>end) return;
        if(l>=start && r<=end) 
        {
            lazy[i]+=val;
            propagate(i, l, r);
            return;
        }
        int mid=l+(r-l)/2;
        updateRange(start, end, 2*i+1, l, mid, val);
        updateRange(start, end, 2*i+2, mid+1, r, val);
        segMax[i]=Math.max(segMax[i*2+1], segMax[i*2+2]);
        segMin[i]=Math.min(segMin[i*2+1], segMin[i*2+2]);
    }
    
    private int findLeftMostZero(int i, int l, int r) //return leftMost 0
    {
        propagate(i, l, r);

        if(segMax[i]<0 || segMin[i]>0) return -1;
        if(l==r) return l;
        int mid=l+(r-l)/2;
        int left=findLeftMostZero(2*i+1, l, mid);
        if(left!=-1) return left;
        return findLeftMostZero(2*i+2, mid+1, r);
    }

    public int longestBalanced(int[] nums) 
    {
        int n=nums.length;
        segMin=new int[n*4];
        segMax=new int[n*4];
        lazy=new int[n*4];

        // int[] cumSum=new int[n]; //cumSum[i]=sum till [i...r]
        int maxL=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int r=0; r<n; r++)
        {
            int val=(nums[r]%2==0)?1:-1;

            int prev=-1;
            if(map.containsKey(nums[r])) prev=map.get(nums[r]);
            //update cumSum kr rhe 0-prev tak -val se
            if(prev!=-1)
            {
                // for(int l=0; l<=prev; l++) cumSum[l]-=val;
                updateRange(0, prev, 0, 0, n-1, -val);
            }

            //update cumSum kr rhe 0-r tak val se
            // for(int l=0; l<=r; l++) cumSum[l]+=val;
            updateRange(0, r, 0, 0, n-1, val);

            //find leftmost 0 in cumSum
            // for(int i=0; i<=r; i++)
            // {
            //     if(cumSum[i]==0)
            //     {
            //         maxL=Math.max(maxL, r-i+1);
            //         break;
            //     }
            // }
            int leftMostZero=findLeftMostZero(0, 0, n-1);
            if(leftMostZero!=-1) maxL=Math.max(maxL, r-leftMostZero+1);
            map.put(nums[r], r);
        }
        return maxL;
    }
}