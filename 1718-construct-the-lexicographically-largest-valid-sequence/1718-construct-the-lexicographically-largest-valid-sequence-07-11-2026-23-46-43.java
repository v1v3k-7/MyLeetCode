class Solution {
    public int[] constructDistancedSequence(int n) 
    {
        int[] res=new int[n*2-1];
        boolean[] used=new boolean[n+1];
        backtrack(0, n, res, used);
        return res;
    }
    private boolean backtrack(int idx, int n, int[] res, boolean[] used)
    {
        if(idx>=n*2-1) return true;
        
        if(res[idx]!=0)
        {
            return backtrack(idx+1, n, res, used);
        }

        for(int i=n; i>=1; i--)
        {
            if(used[i]) continue;

            res[idx]=i;
            used[i]=true;
            if(i==1)
            {
                if(backtrack(idx+1, n, res, used)) return true;
            }
            else
            {
                int j=idx+i;
                if(j<2*n-1 && res[j]==0)
                {
                    res[j]=i;
                    if(backtrack(idx+1, n, res, used)) return true;
                    res[j]=0;
                }
            }
            res[idx]=0;
            used[i]=false;
        }
        return false;
    }
}