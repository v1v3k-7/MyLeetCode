class Solution 
{
    public int smallestNumber(int n, int t) 
    {
        for(int i=n; i<n+10; i++)
        {
            if(product(i)%t==0) return i;
        }
        return -1;
    }
    private int product(int no)
    {
        int res=1;
        for(; no!=0; no/=10)
        {
            res*=(no%10);
        }
        return res;
    }
}