class Solution {
    public int repeatedStringMatch(String a, String b) 
    {
        int n=a.length(); //text len
        int m=b.length(); //pat len
        int rep=1;
        StringBuilder sb=new StringBuilder("");
        if(n<m)
        {
            if(m%n==0) rep=m/n;
            else rep=(m/n)+1;
        }

        //make a(text) to bigger or equal to b(pattern)
        for(int i=0; i<rep; i++) sb.append(a);

        //one extra append
        sb.append(a); 
        rep++;

        int z=sb.length(); //new len of a->sb

        int[] lps=buildLPS(b);
        //now find match and match ka last index; (use knuth morris pratt algorithm) or we can use indexOf too
        // int i=0; //text -> a->sb
        int j=0; //pattern -> b

        int lastIndexOfMatch=-1;
        for(int i=0; i<z; i++)
        {
            //mismatch
            while(j>0 && sb.charAt(i)!=b.charAt(j)) j=lps[j-1];
            //jth char of pattern is matched
            if(sb.charAt(i)==b.charAt(j)) j++;
            //all pattern is matched
            if(j==m)
            {
                lastIndexOfMatch=i;
                break; 
            }
        }
        if(lastIndexOfMatch==-1) return -1;
        if(lastIndexOfMatch<(rep-1)*n) return rep-1;
        else return rep;
    }
    public int[] buildLPS(String s)
    {
        int n=s.length();
        int[] lps=new int[n];
        lps[0]=0;
        int len=0;
        for(int i=1; i<n; i++)
        {
            while(len>0 && s.charAt(i)!=s.charAt(len)) len=lps[len-1];
            if(s.charAt(i)==s.charAt(len)) len++;
            lps[i]=len;
        }
        return lps;
    }
}