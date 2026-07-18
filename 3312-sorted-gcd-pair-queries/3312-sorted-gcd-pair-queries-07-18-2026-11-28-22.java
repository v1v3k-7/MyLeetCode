class Solution {
    public int[] gcdValues(int[] nums, long[] queries) 
    {
        int maxVal=Integer.MIN_VALUE;
        for(int no: nums)
        {
            if(maxVal<no) maxVal=no;
        }

        int[] factorFreq=new int[maxVal+1];
        for(int no: nums)
        {
            for(int i=1; i*i<=no; i++)
            {
                if(no%i==0)
                {
                    factorFreq[i]++;
                    if(no/i!=i) factorFreq[no/i]++;
                }
            }
        }

        long[] pairsCount=new long[maxVal+1]; //index will be the gcd of that count(val)
        for(int i=maxVal; i>=1; i--)
        {
            int freq=factorFreq[i];
            long pairs=1L * freq*(freq-1)/2; //nC2 se total no of pairs nikal lenge agar hmpe freq hai kisi factor ka to
            pairsCount[i]=pairs;

            //count ko sahi kro
            for(int mul=i*2; mul<=maxVal; mul+=i)
            {
                pairsCount[i]-=pairsCount[mul];
            }
        }

        long[] cumPairsCount=new long[maxVal+1];
        cumPairsCount[0]=pairsCount[0];
        for(int i=1; i<=maxVal; i++) cumPairsCount[i]=cumPairsCount[i-1]+pairsCount[i];

        int[] res=new int[queries.length]; 
        for(int i=0; i<queries.length; i++)
        {
            long index=queries[i] + 1;
            res[i]=binarySearchOnCummulativeSum(cumPairsCount, index);
        }
        return res;

    }
    private int binarySearchOnCummulativeSum(long[] arr, long no)
    {
        int li=0, hi=arr.length-1;
        while(li<=hi)
        {
            int mid=li+(hi-li)/2;
            if(arr[mid]>=no) hi=mid-1;
            else li=mid+1; //chhota ya equal ho to;
        }
        return li;
    }
}