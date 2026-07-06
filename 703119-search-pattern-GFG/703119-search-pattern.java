class Solution {
    ArrayList<Integer> search(String pat, String txt) 
    {
        ArrayList<Integer> res=new ArrayList<>();
        int n=txt.length();
        int m=pat.length();
        if(m>n) return res;
        
        int[] lps=LPS(pat);
        int j=0;
        for(int i=0; i<n; i++)
        {
            while(j>0 && txt.charAt(i)!=pat.charAt(j)) j=lps[j-1];
            if(txt.charAt(i)==pat.charAt(j)) j++;
            if(j==m) 
            {
                res.add(i-m+1);
                j=lps[j-1];
            }
        }
        return res;
    }
    public int[] LPS(String pat)
    {
        int n=pat.length();
        int[] lps=new int[n];
        lps[0]=0;
        int len=0;
        for(int i=1; i<n; i++)
        {
            while(len>0 && pat.charAt(len)!=pat.charAt(i)) len=lps[len-1];
            if(pat.charAt(len)==pat.charAt(i)) len++;
            lps[i]=len;
        }
        return lps;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna