class Solution {
    public boolean[] transformStr(String s, String[] strs) 
    {
        int n=s.length();
        int totalOnes=0;
        int prefixOne[]=new int[n];
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i)=='1') totalOnes++;
            prefixOne[i]=totalOnes;
        }

        int m=strs.length;
        boolean res[]=new boolean[m];
        for(int i=0; i<m; i++)
        {
            char[] str=strs[i].toCharArray();

            int fixedOnes=0;
            int question=0;
            for(char ch: str)
            {
                if(ch=='1') fixedOnes++;
                else if(ch=='?') question++;
            }

            if(fixedOnes>totalOnes || totalOnes>fixedOnes+question) 
            {
                res[i]=false;
                continue;
            }

            int need=totalOnes-fixedOnes;
            for(int j=str.length-1; j>=0 && need!=0; j--)
            {
                if(str[j]=='?') 
                {
                    str[j]='1';
                    need--;
                }
            }

            int oneCount=0;
            boolean possible=true;
            for(int j=0; j<str.length; j++)
            {
                if(str[j]=='1') oneCount++;
                if(oneCount>prefixOne[j]) 
                {
                    possible=false;
                    break;
                }
            }
            res[i]=possible;
        }
        return res;
    }
}