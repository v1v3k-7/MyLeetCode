class Solution 
{
    static final long MOD = 1_000_000_007L;
    public int[] sumAndMultiply(String s, int[][] queries) 
    {
        int n=s.length();
        long[] prefixSum=new long[n];
        long[] numUpTo=new long[n];
        int[] nonZeroCnt=new int[n];
        long[] pow10=new long[n+1];

        prefixSum[0]=s.charAt(0)-'0';
        pow10[0]=1;
        nonZeroCnt[0]=s.charAt(0)=='0'?0:1;
        numUpTo[0]=s.charAt(0)-'0';

        for(int i=1; i<n; i++)
        {
            int digit=s.charAt(i)-'0';

            prefixSum[i]=prefixSum[i-1]+digit;
            pow10[i]=pow10[i-1]*10 % MOD;
            nonZeroCnt[i]=nonZeroCnt[i-1] + ((digit==0)?0:1);

            if(digit==0)
            {
                numUpTo[i]=numUpTo[i-1];
            }
            else
            {
                numUpTo[i]=(numUpTo[i-1]*10 + digit) % MOD;
            }
        }
        pow10[n]=pow10[n-1]*10 % MOD;

        int m=queries.length;
        int[] res=new int[m];

        for(int i=0; i<m; i++)
        {
            int l=queries[i][0];
            int r=queries[i][1];

            int cntBefore=(l==0)?0:nonZeroCnt[l-1];

            int subStrLen=nonZeroCnt[r]-cntBefore;
            if(subStrLen==0)
            {
                res[i]=0;
                continue;
            }

            long sumBefore=(l==0)?0:prefixSum[l-1];
            long sum=prefixSum[r]-sumBefore;

            long numsBefore=(l==0)?0:numUpTo[l-1];
            long x=(numUpTo[r] - (numsBefore*pow10[subStrLen] % MOD) + MOD) % MOD;
            int ans=(int) ((sum*x)%MOD);
            res[i]=ans;
        }
        return res;
    }
}