class Solution 
{
    private long nCr(int n, int r, int k)
    {
        r=Math.min(r, n-r); //nCr=nC(n-r);
        long res=1;
        for(int i=1; i<=r; i++)
        {
            res = res * (n-r+i)/i;
            if(res>=k) return k;
        }
        return res;
    }

    public String smallestPalindrome(String s, int k) 
    {
        int[] freq=new int[26];
        int n=s.length();
        int half=n/2;
        char mid=' ';
        if((n&1)==1)
        {
            mid=s.charAt(half);
        }
        for(int i=0; i<half; i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<half; i++)
        {
            boolean placed=false;
            for(int j=0; j<26; j++)
            {
                if(freq[j]>0)
                {
                    freq[j]--;
                    int remaining_letters=half-i-1;
                    long ways=1;
                    for(int x=0; x<26; x++)
                    {
                        if(freq[x]>0)
                        {
                            ways*=nCr(remaining_letters, freq[x], k);
                            remaining_letters-=freq[x];
                        }
                        if(ways>=k) break;
                    }
                    if(ways>=k)
                    {
                        placed=true;
                        sb.append((char)(j+'a'));
                        break;
                    }
                    freq[j]++;
                    k=k-(int)ways; //wen k>ways
                }
            }
            if(!placed) return "";
        }
        String left=sb.toString();
        String right=sb.reverse().toString();
        if(mid==' ')
        {
            return left+right;
        }
        return left+mid+right;
    }
}