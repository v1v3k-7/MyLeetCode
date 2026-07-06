class Solution 
{
    //Manacher's Algorithm
    public String longestPalindrome(String s) 
    {
        int n=s.length();
        int start=0;
        int maxLen=0;

        //---- ODD ------
        int l=0, r=-1;
        int[] d1=new int[n]; //stores radius including start
        for(int i=0; i<n; i++)
        {
            int mir=l+(r-i);
            int len=(i>r)?1:Math.min(d1[mir], r-i+1);

            while(i-len>=0 && i+len<n && s.charAt(i-len)==s.charAt(i+len)) len++;
            d1[i]=len;
            if(2*len-1>maxLen)
            {
                start=i-len+1;
                maxLen=2*len-1;
            }
            if(i+len-1>r)
            {
                l=i-len+1;
                r=i+len-1;
            }
        }

        // ---- EVEN ------
        l=0;
        r=-1;
        int[] d2=new int[n]; 
        for(int i=0; i<n; i++)
        {
            int mir=l+(r-i)+1;
            int len=(i>r)?0:Math.min(d2[mir], r-i+1);
            while(i-len-1>=0 && i+len<n && s.charAt(i-len-1)==s.charAt(i+len))
            {
                len++;
            }
            d2[i]=len;
            if(2*len>maxLen)
            {
                start=i-len;
                maxLen=2*len;
            }
            if(i+len-1>r)
            {
                r=i+len-1;
                l=i-len;
            }
        }
        return s.substring(start, start+maxLen);
    }
}