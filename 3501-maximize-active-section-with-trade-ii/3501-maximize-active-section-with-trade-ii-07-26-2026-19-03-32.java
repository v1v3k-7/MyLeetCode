class Solution 
{
    int[] segTree;
    private void buildSegTree(int i, int l, int r, int[] pairSum)
    {
        if(l==r)
        {
            segTree[i]=pairSum[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildSegTree(2*i+1, l, mid, pairSum);
        buildSegTree(2*i+2, mid+1, r, pairSum);
        segTree[i]=Math.max(segTree[2*i+1], segTree[2*i+2]);
    }
    private int maxPairSumQuery(int start, int end, int i, int l, int r)
    {
        if(l>end || r<start) return Integer.MIN_VALUE;
        if(l>=start && r<=end) return segTree[i];
        int mid=l+(r-l)/2;
        int left=maxPairSumQuery(start, end, 2*i+1, l, mid);
        int right=maxPairSumQuery(start, end, 2*i+2, mid+1, r);
        return Math.max(left, right);
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) 
    {
        List<Integer> res=new ArrayList<>();
        int n=s.length();
        int totalOnes=0;
        //block for zero
        List<Integer> startBlock=new ArrayList<>(); //starting index of each zero block
        List<Integer> endBlock=new ArrayList<>(); //ending index of each zero block
        List<Integer> sizeBlock=new ArrayList<>(); //size of each zero block
        int i=0;
        while(i<n)
        {
            int zero=0;
            while(i<n && s.charAt(i)=='0') 
            {
                zero++;
                i++;
            }
            if(zero>0)
            {
                startBlock.add(i-zero);
                endBlock.add(i-1);
                sizeBlock.add(zero);
            }
            if(i==n) break;
            totalOnes++;
            i++;
        }
        int zeroBlock=sizeBlock.size();
        if(zeroBlock<2)
        {
            for(int[] query: queries)
            {
                int l=query[0], r=query[1];
                res.add(totalOnes);
            }
            return res;
        }

        int[] pairSum=new int[zeroBlock-1];
        for(i=1; i<zeroBlock; i++)
        {
            pairSum[i-1]=sizeBlock.get(i)+sizeBlock.get(i-1);
        }
        n=pairSum.length;
        segTree=new int[4*n];
        buildSegTree(0, 0, n-1, pairSum);

        for(int[] query: queries)
        {
            int l=query[0], r=query[1];
            int low=equalOrGreater(endBlock, l); //start zero block index
            int high=justGreater(startBlock, r)-1; //end zero block index
            
            if(low>=high) //one block or no block of zero
            {
                res.add(totalOnes);
            }
            else if(high-low==1) //2 block of zero only
            {
                int firstBlockLen=endBlock.get(low)-Math.max(l, startBlock.get(low))+1;
                int lastBlockLen=Math.min(r, endBlock.get(high))-startBlock.get(high)+1;
                res.add(firstBlockLen+lastBlockLen + totalOnes);
            }
            else
            {
                int firstBlockLen=endBlock.get(low)-Math.max(l, startBlock.get(low))+1;
                int lastBlockLen=Math.min(r, endBlock.get(high))-startBlock.get(high)+1;
                int firstPairSum=firstBlockLen+sizeBlock.get(low+1);
                int lastPairSum=lastBlockLen+sizeBlock.get(high-1);
                int maxPairSum=maxPairSumQuery(low+1, high-2, 0, 0, n-1);
                int bestPairSum=Math.max(maxPairSum, Math.max(firstPairSum, lastPairSum));
                res.add(bestPairSum + totalOnes);
            }
        }
        return res;
    }

    private int equalOrGreater(List<Integer> list, int i)
    {
        int low=0, high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)>=i) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    private int justGreater(List<Integer> list, int i)
    {
        int low=0, high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)>i) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}