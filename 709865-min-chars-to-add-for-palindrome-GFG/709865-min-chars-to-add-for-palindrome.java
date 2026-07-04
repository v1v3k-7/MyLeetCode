class Solution {
    public int minChar(String s) 
    {
        int n=s.length();
        String rev="$" + new StringBuilder(s).reverse().toString();
        int lps[]=longestPrefixSuffix(s+rev);
        return n-lps[n*2];
    }
    public int[] longestPrefixSuffix(String s)
    {
        int n=s.length();
        int[] lps=new int[n];
        lps[0]=0;
        int len=0;
        for(int i=1;i<n;i++)
        {
            while(len>0 && s.charAt(len)!=s.charAt(i)) len=lps[len-1];
            
            if(s.charAt(len)==s.charAt(i)) len++;
            lps[i]=len;
        }
        return lps;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna