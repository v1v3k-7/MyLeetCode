class Solution {
    public int findLongestChain(int[][] pairs) 
    {
        Arrays.sort(pairs, (a,b)->Integer.compare(a[0], b[0]));

        return solve(0, pairs, -1);
    }
    private int solve(int idx, int[][] pairs, int prev)
    {
        if(idx==pairs.length) return 0;

        int pick=0;
        if(prev==-1 || pairs[idx][0]>pairs[prev][1])
        {
            pick=1+solve(idx+1, pairs, idx);
        }
        int noPick=solve(idx+1, pairs, prev);

        return Math.max(pick, noPick);
    }
}
