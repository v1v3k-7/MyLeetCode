class Solution {
    public int maxActiveSectionsAfterTrade(String s) 
    {
        int n=s.length();
        List<Integer> zeroBlocks=new ArrayList<>();
        int oneCount=0;
        int i=0;
        while(i<n)
        {
            int zeroCount=0;
            while(i<n && s.charAt(i)=='0') 
            {
                zeroCount++;
                i++;
            }
            if(zeroCount>0) zeroBlocks.add(zeroCount);

            if(i<n && s.charAt(i)=='1') oneCount++;
            i++;
        }

        int zeroBlockSize=zeroBlocks.size();
        if(zeroBlockSize==1 || zeroBlockSize==0) return oneCount;

        int maxZero=0;
        for(i=1; i<zeroBlockSize; i++)
        {
            maxZero=Math.max(maxZero, zeroBlocks.get(i)+zeroBlocks.get(i-1));
        }

        return maxZero+oneCount;
    }
}