class Solution {
    public int strStr(String text, String pat) 
    {
        int n=text.length();
        int m=pat.length();
        if(m>n) return -1;
        int base=256;
        int mod=101; //prime no

        int h=1;
        for(int i=0; i<m-1; i++)
        {
            h=(h*base)%mod;
        }

        //initialized window hash and pattern hash
        int wh=0;
        int ph=0;
        for(int i=0; i<m; i++)
        {
            wh=(wh*base + text.charAt(i))%mod;
            ph=(ph*base + pat.charAt(i))%mod;
        }

        //solve for next window
        for(int i=0; i<=n-m; i++)
        {
            //compare 
            if(wh==ph)
            {
                int j=0;
                while(j<m)
                {
                    if(text.charAt(i+j)!=pat.charAt(j)) break;
                    j++;
                }
                if(j==m) return i;
            }

            //rolling hash
            if(i<n-m)
            {
                wh = (wh - text.charAt(i) *h) %mod;
                wh = (wh * 256 + text.charAt(i+m))%mod;
                if(wh<0) wh+=mod;
            }
        }
        return -1;
    }
}