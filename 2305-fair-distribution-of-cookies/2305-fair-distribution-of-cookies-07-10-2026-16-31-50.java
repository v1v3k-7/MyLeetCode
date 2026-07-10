class Solution {
    public int distributeCookies(int[] cookies, int k) 
    {
        int[] children=new int[k];
        return backtrack(cookies, 0, k, children);
    }
    private int backtrack(int[] cookies, int i, int k, int[] children)
    {
        if(i==cookies.length)
        {
            return max(children);
        }

        int res=Integer.MAX_VALUE;
        for(int c=0; c<k; c++)
        {
            children[c]+=cookies[i];
            int x=backtrack(cookies, i+1, k, children);
            children[c]-=cookies[i];

            // res=Math.min(x, res);
            if(x<res) res=x;
        }
        return res;
    }


    public int max(int[] nums)
    {
        int res=Integer.MIN_VALUE;
        for(int no: nums)
        {
            if(no>res) res=no;
        }
        return res;
    }
}