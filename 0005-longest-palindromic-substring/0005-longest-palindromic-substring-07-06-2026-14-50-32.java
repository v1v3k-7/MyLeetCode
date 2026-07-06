class Solution 
{
    //Manacher's Algorithm
    public String transform(String s)
    {
        StringBuilder sb=new StringBuilder("");
        for(char ch: s.toCharArray())
        {
            sb.append('#');
            sb.append(ch);
        }
        sb.append('#');
        return sb.toString();
    }

    public String longestPalindrome(String s) 
    {
        String t=transform(s);
        int n=t.length();
        int l=0, r=-1;
        int center=0;
        int maxLen=0;
        int[] p=new int[n];
        p[0]=0;
        p[n-1]=0;
        for(int i=1; i<n-1; i++)
        {
            int mirror=l+(r-i);
            int len=(i>r)?0:Math.min(p[mirror], r-i);

            while(i-len>=0 && i+len<n && t.charAt(i-len)==t.charAt(i+len)) len++;
            len--;
            p[i]=len; //itne len expansion tak palindrome hai ye i

            if(len>maxLen)
            {
                center=i/2;
                maxLen=len;
            }
            if(i+len>r)
            {
                l=i-len;
                r=i+len;
            }
        }
        int start=center - maxLen/2;
        return s.substring(start, start+maxLen);
    }
}